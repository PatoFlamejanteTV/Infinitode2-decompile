/*      */ package org.a.a.a;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.net.URL;
/*      */ import java.security.AccessController;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Properties;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class c
/*      */ {
/*      */   static {
/*      */     String str;
/*      */   }
/*      */   
/*      */   static void a(String paramString) {
/*   45 */     c(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static PrintStream a = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final ClassLoader c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  282 */   private static Hashtable d = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  299 */   private static volatile c e = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Hashtable d() {
/*      */     String str;
/*  317 */     Hashtable hashtable = null;
/*      */     
/*      */     try {
/*  320 */       str = a("org.apache.commons.logging.LogFactory.HashtableImpl", (String)null);
/*  321 */     } catch (SecurityException securityException) {
/*      */ 
/*      */       
/*  324 */       str = null;
/*      */     } 
/*      */     
/*  327 */     if (str == null) {
/*  328 */       str = "org.apache.commons.logging.impl.WeakHashtable";
/*      */     }
/*      */     try {
/*      */       Class clazz;
/*  332 */       hashtable = (Hashtable)(clazz = Class.forName(str)).newInstance();
/*  333 */     } catch (Throwable throwable2) {
/*  334 */       Throwable throwable1; a(throwable1 = null);
/*      */ 
/*      */       
/*  337 */       if (!"org.apache.commons.logging.impl.WeakHashtable".equals(str))
/*      */       {
/*  339 */         if (c()) {
/*      */           
/*  341 */           c("[ERROR] LogFactory: Load of custom hashtable failed");
/*      */         }
/*      */         else {
/*      */           
/*  345 */           System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
/*      */         } 
/*      */       }
/*      */     } 
/*  349 */     if (hashtable == null) {
/*  350 */       hashtable = new Hashtable();
/*      */     }
/*  352 */     return hashtable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String b(String paramString) {
/*  359 */     if (paramString == null) {
/*  360 */       return null;
/*      */     }
/*  362 */     return paramString.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(Throwable paramThrowable) {
/*  378 */     if (paramThrowable instanceof ThreadDeath) {
/*  379 */       throw (ThreadDeath)paramThrowable;
/*      */     }
/*  381 */     if (paramThrowable instanceof VirtualMachineError) {
/*  382 */       throw (VirtualMachineError)paramThrowable;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static c e() {
/*      */     ClassLoader classLoader1;
/*  421 */     if ((classLoader1 = f()) == null)
/*      */     {
/*      */ 
/*      */       
/*  425 */       if (c()) {
/*  426 */         c("Context classloader is null.");
/*      */       }
/*      */     }
/*      */     
/*      */     c c1;
/*      */     
/*  432 */     if ((c1 = a(classLoader1)) != null) {
/*  433 */       return c1;
/*      */     }
/*      */     
/*  436 */     if (c()) {
/*  437 */       c("[LOOKUP] LogFactory implementation requested for the first time for context classloader " + a(classLoader1));
/*      */ 
/*      */       
/*  440 */       b("[LOOKUP] ", classLoader1);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  453 */     Properties properties = c(classLoader1, "commons-logging.properties");
/*      */ 
/*      */ 
/*      */     
/*  457 */     ClassLoader classLoader2 = classLoader1; String str;
/*  458 */     if (properties != null && (
/*      */       
/*  460 */       str = properties.getProperty("use_tccl")) != null)
/*      */     {
/*      */       
/*  463 */       if (!Boolean.valueOf(str).booleanValue())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  471 */         classLoader2 = c;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  478 */     if (c()) {
/*  479 */       c("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  485 */       if ((str = a("org.a.a.a.c", (String)null)) != null) {
/*  486 */         if (c()) {
/*  487 */           c("[LOOKUP] Creating an instance of LogFactory class '" + str + "' as specified by system property org.apache.commons.logging.LogFactory");
/*      */         }
/*      */         
/*  490 */         c1 = a(str, classLoader2, classLoader1);
/*      */       }
/*  492 */       else if (c()) {
/*  493 */         c("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
/*      */       }
/*      */     
/*  496 */     } catch (SecurityException securityException) {
/*  497 */       if (c()) {
/*  498 */         c("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + b(securityException.getMessage()) + "]. Trying alternative implementations...");
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  503 */     catch (RuntimeException runtimeException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  509 */       if (c()) {
/*  510 */         c("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [" + b(runtimeException.getMessage()) + "] as specified by a system property.");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  515 */       throw runtimeException;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  524 */     if (c1 == null) {
/*  525 */       if (c()) {
/*  526 */         c("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
/*      */       }
/*      */       
/*      */       try {
/*      */         InputStream inputStream;
/*      */         
/*  532 */         if ((inputStream = a(classLoader1, "META-INF/services/org.apache.commons.logging.LogFactory")) != null) {
/*      */           BufferedReader bufferedReader;
/*      */ 
/*      */           
/*      */           try {
/*  537 */             bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/*  538 */           } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  539 */             bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*      */           } 
/*      */           
/*  542 */           String str1 = bufferedReader.readLine();
/*  543 */           bufferedReader.close();
/*      */           
/*  545 */           if (str1 != null && !"".equals(str1)) {
/*  546 */             if (c()) {
/*  547 */               c("[LOOKUP]  Creating an instance of LogFactory class " + str1 + " as specified by file 'META-INF/services/org.apache.commons.logging.LogFactory" + "' which was present in the path of the context classloader.");
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*  552 */             c1 = a(str1, classLoader2, classLoader1);
/*      */           }
/*      */         
/*      */         }
/*  556 */         else if (c()) {
/*  557 */           c("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
/*      */         }
/*      */       
/*  560 */       } catch (Exception exception) {
/*      */ 
/*      */ 
/*      */         
/*  564 */         if (c()) {
/*  565 */           c("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [" + b(exception.getMessage()) + "]. Trying alternative implementations...");
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  577 */     if (c1 == null) {
/*  578 */       if (properties != null) {
/*  579 */         if (c()) {
/*  580 */           c("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  585 */         if ((str = properties.getProperty("org.a.a.a.c")) != null) {
/*  586 */           if (c()) {
/*  587 */             c("[LOOKUP] Properties file specifies LogFactory subclass '" + str + "'");
/*      */           }
/*      */           
/*  590 */           c1 = a(str, classLoader2, classLoader1);
/*      */ 
/*      */         
/*      */         }
/*  594 */         else if (c()) {
/*  595 */           c("[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
/*      */         }
/*      */       
/*      */       }
/*  599 */       else if (c()) {
/*  600 */         c("[LOOKUP] No properties file available to determine LogFactory subclass from..");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  607 */     if (c1 == null) {
/*  608 */       if (c()) {
/*  609 */         c("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  624 */       c1 = a("org.apache.commons.logging.impl.LogFactoryImpl", c, classLoader1);
/*      */     } 
/*      */     
/*  627 */     if (c1 != null) {
/*      */ 
/*      */ 
/*      */       
/*  631 */       a(classLoader1, c1);
/*      */       
/*  633 */       if (properties != null) {
/*  634 */         Enumeration enumeration = properties.propertyNames();
/*  635 */         while (enumeration.hasMoreElements()) {
/*  636 */           String str1 = (String)enumeration.nextElement();
/*  637 */           properties.getProperty(str1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  643 */     return c1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static a a(Class paramClass) {
/*  655 */     return e().a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ClassLoader b(Class paramClass) {
/*      */     try {
/*  762 */       return paramClass.getClassLoader();
/*  763 */     } catch (SecurityException securityException) {
/*  764 */       if (c()) {
/*  765 */         c("Unable to get classloader for class '" + paramClass + "' due to security restrictions - " + securityException.getMessage());
/*      */       }
/*      */       
/*  768 */       throw securityException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ClassLoader f() {
/*  808 */     return AccessController.<ClassLoader>doPrivileged(new d());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static ClassLoader b() {
/*  837 */     ClassLoader classLoader = null;
/*      */     
/*      */     try {
/*  840 */       classLoader = Thread.currentThread().getContextClassLoader();
/*  841 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  855 */     return classLoader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static c a(ClassLoader paramClassLoader) {
/*  873 */     if (paramClassLoader == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  878 */       return e;
/*      */     }
/*  880 */     return (c)d.get(paramClassLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(ClassLoader paramClassLoader, c paramc) {
/*  897 */     if (paramc != null) {
/*  898 */       if (paramClassLoader == null) {
/*  899 */         e = paramc; return;
/*      */       } 
/*  901 */       d.put(paramClassLoader, paramc);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static c a(String paramString, ClassLoader paramClassLoader1, ClassLoader paramClassLoader2) {
/*      */     b b;
/*  964 */     if (paramString = AccessController.doPrivileged(new e(paramString, paramClassLoader1)) instanceof b) {
/*  965 */       b = (b)paramString;
/*  966 */       if (c()) {
/*  967 */         c("An error occurred while loading the factory class:" + b.getMessage());
/*      */       }
/*  969 */       throw b;
/*      */     } 
/*  971 */     if (c()) {
/*  972 */       c("Created object " + a(b) + " to manage classloader " + a(paramClassLoader2));
/*      */     }
/*      */     
/*  975 */     return (c)b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static Object a(String paramString, ClassLoader paramClassLoader) {
/* 1012 */     Class clazz = null; try {
/*      */       boolean bool;
/* 1014 */       if (paramClassLoader != null) {
/*      */         
/*      */         try {
/*      */ 
/*      */ 
/*      */           
/* 1020 */           clazz = paramClassLoader.loadClass(paramString);
/* 1021 */           if (((f == null) ? (f = d("org.a.a.a.c")) : f).isAssignableFrom(clazz)) {
/* 1022 */             if (c()) {
/* 1023 */               c("Loaded class " + clazz.getName() + " from classloader " + a(paramClassLoader));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1038 */           else if (c()) {
/* 1039 */             c("Factory class " + clazz.getName() + " loaded from classloader " + a(clazz.getClassLoader()) + " does not extend '" + ((f == null) ? (f = d("org.a.a.a.c")) : f).getName() + "' as loaded by this classloader.");
/*      */ 
/*      */ 
/*      */             
/* 1043 */             b("[BAD CL TREE] ", paramClassLoader);
/*      */           } 
/*      */ 
/*      */           
/* 1047 */           return clazz.newInstance();
/*      */         }
/* 1049 */         catch (ClassNotFoundException classNotFoundException) {
/* 1050 */           if (paramClassLoader == c)
/*      */           {
/* 1052 */             if (c()) {
/* 1053 */               c("Unable to locate any class called '" + paramString + "' via classloader " + a(paramClassLoader));
/*      */             }
/*      */             
/* 1056 */             throw classNotFoundException;
/*      */           }
/*      */         
/* 1059 */         } catch (NoClassDefFoundError noClassDefFoundError) {
/* 1060 */           if (paramClassLoader == c)
/*      */           {
/* 1062 */             if (c()) {
/* 1063 */               c("Class '" + paramString + "' cannot be loaded via classloader " + a(paramClassLoader) + " - it depends on some other class that cannot be found.");
/*      */             }
/*      */ 
/*      */             
/* 1067 */             throw noClassDefFoundError;
/*      */           }
/*      */         
/* 1070 */         } catch (ClassCastException classCastException) {
/* 1071 */           if (paramClassLoader == c) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1077 */             bool = c(clazz);
/*      */ 
/*      */ 
/*      */             
/*      */             StringBuffer stringBuffer;
/*      */ 
/*      */ 
/*      */             
/* 1085 */             (stringBuffer = new StringBuffer()).append("The application has specified that a custom LogFactory implementation ");
/* 1086 */             stringBuffer.append("should be used but Class '");
/* 1087 */             stringBuffer.append(paramString);
/* 1088 */             stringBuffer.append("' cannot be converted to '");
/* 1089 */             stringBuffer.append(((f == null) ? (f = d("org.a.a.a.c")) : f).getName());
/* 1090 */             stringBuffer.append("'. ");
/* 1091 */             if (bool) {
/* 1092 */               stringBuffer.append("The conflict is caused by the presence of multiple LogFactory classes ");
/* 1093 */               stringBuffer.append("in incompatible classloaders. ");
/* 1094 */               stringBuffer.append("Background can be found in http://commons.apache.org/logging/tech.html. ");
/* 1095 */               stringBuffer.append("If you have not explicitly specified a custom LogFactory then it is likely ");
/* 1096 */               stringBuffer.append("that the container has set one without your knowledge. ");
/* 1097 */               stringBuffer.append("In this case, consider using the commons-logging-adapters.jar file or ");
/* 1098 */               stringBuffer.append("specifying the standard LogFactory from the command line. ");
/*      */             } else {
/* 1100 */               stringBuffer.append("Please check the custom implementation. ");
/*      */             } 
/* 1102 */             stringBuffer.append("Help can be found @http://commons.apache.org/logging/troubleshooting.html.");
/*      */             
/* 1104 */             if (c()) {
/* 1105 */               c(stringBuffer.toString());
/*      */             }
/*      */             
/* 1108 */             throw new ClassCastException(stringBuffer.toString());
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1142 */       if (c()) {
/* 1143 */         c("Unable to load factory class via classloader " + a(bool) + " - trying the classloader associated with this LogFactory.");
/*      */       }
/*      */ 
/*      */       
/* 1147 */       return (clazz = Class.forName(paramString)).newInstance();
/* 1148 */     } catch (Exception exception) {
/*      */       
/* 1150 */       if (c()) {
/* 1151 */         c("Unable to create LogFactory instance.");
/*      */       }
/* 1153 */       if (clazz != null && !((f == null) ? (f = d("org.a.a.a.c")) : f).isAssignableFrom(clazz)) {
/* 1154 */         return new b("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", exception);
/*      */       }
/*      */ 
/*      */       
/* 1158 */       return new b(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class d(String paramString) {
/*      */     try {
/*      */       return Class.forName(paramString);
/*      */     } catch (ClassNotFoundException classNotFoundException) {
/*      */       throw new NoClassDefFoundError(classNotFoundException.getMessage());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean c(Class paramClass) {
/* 1175 */     boolean bool = false;
/* 1176 */     if (paramClass != null) {
/*      */       try {
/*      */         ClassLoader classLoader;
/* 1179 */         if ((classLoader = paramClass.getClassLoader()) == null) {
/* 1180 */           c("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
/*      */         } else {
/* 1182 */           b("[CUSTOM LOG FACTORY] ", classLoader);
/*      */           
/*      */           Class clazz;
/*      */           
/* 1186 */           if (bool = (clazz = Class.forName("org.a.a.a.c", false, classLoader)).isAssignableFrom(paramClass)) {
/* 1187 */             c("[CUSTOM LOG FACTORY] " + paramClass.getName() + " implements LogFactory but was loaded by an incompatible classloader.");
/*      */           } else {
/*      */             
/* 1190 */             c("[CUSTOM LOG FACTORY] " + paramClass.getName() + " does not implement LogFactory.");
/*      */           }
/*      */         
/*      */         } 
/* 1194 */       } catch (SecurityException securityException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1200 */         c("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + securityException.getMessage());
/*      */       }
/* 1202 */       catch (LinkageError linkageError) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1209 */         c("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + linkageError.getMessage());
/*      */       }
/* 1211 */       catch (ClassNotFoundException classNotFoundException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1219 */         c("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
/*      */       } 
/*      */     }
/*      */     
/* 1223 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static InputStream a(ClassLoader paramClassLoader, String paramString) {
/* 1233 */     return AccessController.<InputStream>doPrivileged(new f(paramClassLoader, paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Enumeration b(ClassLoader paramClassLoader, String paramString) {
/*      */     g g;
/* 1283 */     return (Enumeration)(g = AccessController.doPrivileged(g = new g(paramClassLoader, paramString)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Properties a(URL paramURL) {
/*      */     h h;
/* 1333 */     return AccessController.<Properties>doPrivileged(h = new h(paramURL));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Properties c(ClassLoader paramClassLoader, String paramString) {
/* 1356 */     Properties properties = null;
/* 1357 */     double d = 0.0D;
/* 1358 */     URL uRL = null;
/*      */     
/*      */     try {
/*      */       Enumeration enumeration;
/* 1362 */       if ((enumeration = b(paramClassLoader, paramString)) == null) {
/* 1363 */         return null;
/*      */       }
/*      */       
/* 1366 */       while (enumeration.hasMoreElements()) {
/*      */         URL uRL1;
/*      */         
/*      */         Properties properties1;
/* 1370 */         if ((properties1 = a(uRL1 = enumeration.nextElement())) != null) {
/* 1371 */           if (properties == null) {
/* 1372 */             uRL = uRL1;
/*      */             
/* 1374 */             String str1 = (properties = properties1).getProperty("priority");
/* 1375 */             d = 0.0D;
/* 1376 */             if (str1 != null) {
/* 1377 */               d = Double.parseDouble(str1);
/*      */             }
/*      */             
/* 1380 */             if (c()) {
/* 1381 */               c("[LOOKUP] Properties file found at '" + uRL1 + "' with priority " + d);
/*      */             }
/*      */             continue;
/*      */           } 
/* 1385 */           String str = properties1.getProperty("priority");
/* 1386 */           double d1 = 0.0D;
/* 1387 */           if (str != null) {
/* 1388 */             d1 = Double.parseDouble(str);
/*      */           }
/*      */           
/* 1391 */           if (d1 > d) {
/* 1392 */             if (c()) {
/* 1393 */               c("[LOOKUP] Properties file at '" + uRL1 + "' with priority " + d1 + " overrides file at '" + uRL + "' with priority " + d);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1399 */             uRL = uRL1;
/* 1400 */             properties = properties1;
/* 1401 */             d = d1; continue;
/*      */           } 
/* 1403 */           if (c()) {
/* 1404 */             c("[LOOKUP] Properties file at '" + uRL1 + "' with priority " + d1 + " does not override file at '" + uRL + "' with priority " + d);
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 1414 */     catch (SecurityException securityException) {
/* 1415 */       if (c()) {
/* 1416 */         c("SecurityException thrown while trying to find/read config files.");
/*      */       }
/*      */     } 
/*      */     
/* 1420 */     if (c()) {
/* 1421 */       if (properties == null) {
/* 1422 */         c("[LOOKUP] No properties file of name '" + paramString + "' found.");
/*      */       } else {
/* 1424 */         c("[LOOKUP] Properties file of name '" + paramString + "' found at '" + uRL + '"');
/*      */       } 
/*      */     }
/*      */     
/* 1428 */     return properties;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String a(String paramString1, String paramString2) {
/* 1442 */     return AccessController.<String>doPrivileged(new i(paramString1, paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PrintStream g() {
/*      */     String str;
/*      */     try {
/* 1460 */       if ((str = a("org.apache.commons.logging.diagnostics.dest", (String)null)) == null) {
/* 1461 */         return null;
/*      */       }
/* 1463 */     } catch (SecurityException securityException) {
/*      */ 
/*      */       
/* 1466 */       return null;
/*      */     } 
/*      */     
/* 1469 */     if (str.equals("STDOUT"))
/* 1470 */       return System.out; 
/* 1471 */     if (str.equals("STDERR")) {
/* 1472 */       return System.err;
/*      */     }
/*      */     
/*      */     try {
/* 1476 */       FileOutputStream fileOutputStream = new FileOutputStream(str, true);
/* 1477 */       return new PrintStream(fileOutputStream);
/* 1478 */     } catch (IOException iOException) {
/*      */       
/* 1480 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean c() {
/* 1495 */     return (a != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final void c(String paramString) {
/* 1517 */     if (a != null) {
/* 1518 */       a.print(b);
/* 1519 */       a.println(paramString);
/* 1520 */       a.flush();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void d(Class paramClass) {
/*      */     ClassLoader classLoader;
/* 1555 */     if (!c()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1563 */       c("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
/* 1564 */       c("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
/* 1565 */     } catch (SecurityException securityException) {
/* 1566 */       c("[ENV] Security setting prevent interrogation of system classpaths.");
/*      */     } 
/*      */     
/* 1569 */     String str = paramClass.getName();
/*      */ 
/*      */     
/*      */     try {
/* 1573 */       classLoader = b(paramClass);
/* 1574 */     } catch (SecurityException securityException) {
/*      */       
/* 1576 */       c("[ENV] Security forbids determining the classloader for " + str);
/*      */       
/*      */       return;
/*      */     } 
/* 1580 */     c("[ENV] Class " + str + " was loaded via classloader " + a(classLoader));
/* 1581 */     b("[ENV] Ancestry of classloader which loaded " + str + " is ", classLoader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void b(String paramString, ClassLoader paramClassLoader) {
/*      */     ClassLoader classLoader;
/* 1592 */     if (!c()) {
/*      */       return;
/*      */     }
/*      */     
/* 1596 */     if (paramClassLoader != null) {
/* 1597 */       String str = paramClassLoader.toString();
/* 1598 */       c(paramString + a(paramClassLoader) + " == '" + str + "'");
/*      */     } 
/*      */     
/*      */     try {
/* 1602 */       classLoader = ClassLoader.getSystemClassLoader();
/* 1603 */     } catch (SecurityException securityException) {
/* 1604 */       c(paramString + "Security forbids determining the system classloader.");
/*      */       return;
/*      */     } 
/* 1607 */     if (paramClassLoader != null) {
/* 1608 */       StringBuffer stringBuffer = new StringBuffer(paramString + "ClassLoader tree:");
/*      */       while (true) {
/* 1610 */         stringBuffer.append(a(paramClassLoader));
/* 1611 */         if (paramClassLoader == classLoader) {
/* 1612 */           stringBuffer.append(" (SYSTEM) ");
/*      */         }
/*      */         
/*      */         try {
/* 1616 */           paramClassLoader = paramClassLoader.getParent();
/* 1617 */         } catch (SecurityException securityException) {
/* 1618 */           stringBuffer.append(" --> SECRET");
/*      */           
/*      */           break;
/*      */         } 
/* 1622 */         stringBuffer.append(" --> ");
/* 1623 */         if (paramClassLoader == null) {
/* 1624 */           stringBuffer.append("BOOT");
/*      */           break;
/*      */         } 
/*      */       } 
/* 1628 */       c(stringBuffer.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String a(Object paramObject) {
/* 1645 */     if (paramObject == null) {
/* 1646 */       return "null";
/*      */     }
/* 1648 */     return paramObject.getClass().getName() + "@" + System.identityHashCode(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1674 */     c = b((f == null) ? (f = d("org.a.a.a.c")) : f);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1686 */       ClassLoader classLoader = c;
/* 1687 */       if (c == null) {
/* 1688 */         str = "BOOTLOADER";
/*      */       } else {
/* 1690 */         str = a(str);
/*      */       } 
/* 1692 */     } catch (SecurityException securityException) {
/* 1693 */       str = "UNKNOWN";
/*      */     } 
/* 1695 */     b = "[LogFactory from " + str + "] ";
/* 1696 */     a = g();
/* 1697 */     d((f == null) ? (f = d("org.a.a.a.c")) : f);
/* 1698 */     d = d();
/* 1699 */     if (c())
/* 1700 */       c("BOOTSTRAP COMPLETED"); 
/*      */   }
/*      */   
/*      */   public abstract a a();
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\a\a\c.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */