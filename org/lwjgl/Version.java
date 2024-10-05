/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Objects;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.Manifest;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Version
/*     */ {
/*     */   public static final int VERSION_MAJOR = 3;
/*     */   public static final int VERSION_MINOR = 3;
/*     */   public static final int VERSION_REVISION = 3;
/*  23 */   public static final BuildType BUILD_TYPE = BuildType.STABLE;
/*     */   
/*  25 */   private static final String versionPlain = "3" + 
/*  26 */     '.' + '\003' + '.' + '\003' + BUILD_TYPE.postfix;
/*     */ 
/*     */ 
/*     */   
/*  30 */   private static final String version = versionPlain + VersionImpl.find();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  36 */     System.out.println(version);
/*  37 */     System.err.println(versionPlain);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/*  42 */     return version;
/*     */   }
/*     */ 
/*     */   
/*     */   public enum BuildType
/*     */   {
/*  48 */     ALPHA("a"),
/*     */     
/*  50 */     BETA("b"),
/*     */     
/*  52 */     STABLE("");
/*     */     
/*     */     public final String postfix;
/*     */     
/*     */     BuildType(String param1String1) {
/*  57 */       this.postfix = param1String1;
/*     */     }
/*     */   }
/*     */   
/*     */   static String createImplementation(String paramString1, String paramString2) {
/*  62 */     paramString2 = "+" + ((paramString2.startsWith("build ") && 6 < paramString2.length()) ? paramString2.substring(6) : paramString2);
/*     */     
/*  64 */     if (paramString1.contains("SNAPSHOT") || paramString1.contains("snapshot")) {
/*  65 */       return "-snapshot" + paramString2;
/*     */     }
/*     */     
/*  68 */     return paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String findImplementationFromManifest() {
/*     */     ClassLoader classLoader;
/*     */     URL uRL;
/*  76 */     if ((uRL = (classLoader = Version.class.getClassLoader()).getResource("org/lwjgl/Version.class")) != null) {
/*  77 */       String str = uRL.toString(); try {
/*     */         URL uRL1;
/*  79 */         if (str.startsWith("jar:")) {
/*     */ 
/*     */ 
/*     */           
/*  83 */           if ((str = readImplementationFromManifest(Objects.requireNonNull(uRL1 = Version.class.getResource("/META-INF/MANIFEST.MF")))) != null) {
/*  84 */             return str;
/*     */           }
/*  86 */         } else if (str.startsWith("resource:")) {
/*  87 */           Enumeration<URL> enumeration = uRL1.getResources("META-INF/MANIFEST.MF");
/*  88 */           while (enumeration.hasMoreElements()) {
/*     */             
/*  90 */             if ((str = readImplementationFromManifest(enumeration.nextElement())) != null) {
/*  91 */               return str;
/*     */             }
/*     */           } 
/*     */         } 
/*  95 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */     
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   private static String readImplementationFromManifest(URL paramURL) {
/*     */     
/* 104 */     try { InputStream inputStream = paramURL.openStream(); Throwable throwable2 = null; 
/* 105 */       try { Attributes attributes = (new Manifest(inputStream)).getMainAttributes();
/*     */ 
/*     */         
/* 108 */         if (!"lwjgl".equals(attributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE))) {
/* 109 */           return null;
/*     */         }
/* 111 */         if (!"lwjgl.org".equals(throwable.getValue(Attributes.Name.IMPLEMENTATION_VENDOR))) {
/* 112 */           return null;
/*     */         }
/*     */         
/* 115 */         String str2 = throwable.getValue(Attributes.Name.SPECIFICATION_VERSION);
/* 116 */         String str1 = throwable.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
/* 117 */         if (str2 == null || str1 == null) {
/* 118 */           str1 = null; return str1;
/*     */         } 
/*     */         
/* 121 */         str1 = createImplementation(str2, str1); return str1; } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 122 */       finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }   }  } catch (Exception exception)
/* 123 */     { return null; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\Version.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */