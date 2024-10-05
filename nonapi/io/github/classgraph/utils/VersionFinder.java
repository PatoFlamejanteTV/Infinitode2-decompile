/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import io.github.classgraph.ClassGraph;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.xpath.XPathFactory;
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
/*     */ public final class VersionFinder
/*     */ {
/*     */   private static final String MAVEN_PACKAGE = "io.github.classgraph";
/*     */   private static final String MAVEN_ARTIFACT = "classgraph";
/*     */   public static final OperatingSystem OS;
/*  67 */   public static final String JAVA_VERSION = getProperty("java.version");
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int JAVA_MAJOR_VERSION;
/*     */ 
/*     */   
/*     */   public static final int JAVA_MINOR_VERSION;
/*     */ 
/*     */   
/*     */   public static final int JAVA_SUB_VERSION;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  82 */     int i = 0;
/*  83 */     int j = 0;
/*  84 */     int k = 0;
/*  85 */     ArrayList<Integer> arrayList = new ArrayList();
/*  86 */     if (JAVA_VERSION != null) {
/*  87 */       String[] arrayOfString; int m; byte b; for (m = (arrayOfString = JAVA_VERSION.split("[^0-9]+")).length, b = 0; b < m; ) { String str1 = arrayOfString[b];
/*     */         try {
/*  89 */           arrayList.add(Integer.valueOf(Integer.parseInt(str1)));
/*  90 */         } catch (NumberFormatException numberFormatException) {}
/*     */         
/*     */         b++; }
/*     */       
/*  94 */       if (!arrayList.isEmpty() && ((Integer)arrayList.get(0)).intValue() == 1)
/*     */       {
/*  96 */         arrayList.remove(0);
/*     */       }
/*  98 */       if (arrayList.isEmpty()) {
/*  99 */         throw new RuntimeException("Could not determine Java version: " + JAVA_VERSION);
/*     */       }
/* 101 */       i = ((Integer)arrayList.get(0)).intValue();
/* 102 */       if (arrayList.size() > 1) {
/* 103 */         j = ((Integer)arrayList.get(1)).intValue();
/*     */       }
/* 105 */       if (arrayList.size() > 2) {
/* 106 */         k = ((Integer)arrayList.get(2)).intValue();
/*     */       }
/*     */     } 
/* 109 */     JAVA_MAJOR_VERSION = i;
/* 110 */     JAVA_MINOR_VERSION = j;
/* 111 */     JAVA_SUB_VERSION = k;
/* 112 */   } public static final boolean JAVA_IS_EA_VERSION = (JAVA_VERSION != null && JAVA_VERSION.endsWith("-ea"));
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OperatingSystem
/*     */   {
/* 118 */     Windows,
/*     */ 
/*     */     
/* 121 */     MacOSX,
/*     */ 
/*     */     
/* 124 */     Linux,
/*     */ 
/*     */     
/* 127 */     Solaris,
/*     */ 
/*     */     
/* 130 */     BSD,
/*     */ 
/*     */     
/* 133 */     Unix,
/*     */ 
/*     */     
/* 136 */     Unknown;
/*     */   }
/*     */   
/*     */   static {
/* 140 */     String str = getProperty("os.name", "unknown").toLowerCase(Locale.ENGLISH);
/* 141 */     if (File.separatorChar == '\\') {
/* 142 */       OS = OperatingSystem.Windows; return;
/* 143 */     }  if (str != null) {
/*     */       
/* 145 */       if (str.contains("win")) {
/* 146 */         OS = OperatingSystem.Windows; return;
/* 147 */       }  if (str.contains("mac") || str.contains("darwin")) {
/* 148 */         OS = OperatingSystem.MacOSX; return;
/* 149 */       }  if (str.contains("nux")) {
/* 150 */         OS = OperatingSystem.Linux; return;
/* 151 */       }  if (str.contains("sunos") || str.contains("solaris")) {
/* 152 */         OS = OperatingSystem.Solaris; return;
/* 153 */       }  if (str.contains("bsd")) {
/* 154 */         OS = OperatingSystem.Unix; return;
/* 155 */       }  if (str.contains("nix") || str.contains("aix")) {
/* 156 */         OS = OperatingSystem.Unix; return;
/*     */       } 
/* 158 */     }  OS = OperatingSystem.Unknown;
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
/*     */ 
/*     */   
/*     */   public static String getProperty(String paramString) {
/*     */     try {
/* 182 */       return System.getProperty(paramString);
/* 183 */     } catch (SecurityException securityException) {
/* 184 */       return null;
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
/*     */   public static String getProperty(String paramString1, String paramString2) {
/*     */     try {
/* 199 */       return System.getProperty(paramString1, paramString2);
/* 200 */     } catch (SecurityException securityException) {
/* 201 */       return null;
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
/*     */   public static synchronized String getVersion() {
/* 214 */     Class<ClassGraph> clazz = ClassGraph.class;
/*     */     try {
/* 216 */       String str = clazz.getName();
/*     */       URL uRL;
/* 218 */       if ((uRL = clazz.getResource("/" + JarUtils.classNameToClassfilePath(str))) != null) {
/* 219 */         Path path = Paths.get(uRL.toURI()).getParent();
/* 220 */         int i = str.length() - str.replace(".", "").length();
/*     */         
/* 222 */         path = path; byte b;
/* 223 */         for (b = 0; b < i && path != null; b++) {
/* 224 */           path = path.getParent();
/*     */         }
/*     */         
/* 227 */         for (b = 0; b < 3 && path != null; b++, path = path.getParent()) {
/* 228 */           Path path1 = path.resolve("pom.xml"); try {
/* 229 */             InputStream inputStream = Files.newInputStream(path1, new java.nio.file.OpenOption[0]); Throwable throwable2 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 240 */           catch (IOException iOException) {}
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 245 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     try { InputStream inputStream = clazz.getResourceAsStream("/META-INF/maven/io.github.classgraph/classgraph/pom.properties"); Throwable throwable2 = null;
/*     */ 
/*     */       
/*     */       try { Properties properties;
/* 254 */         (properties = new Properties()).load(inputStream);
/*     */         String str;
/* 256 */         if (inputStream != null && !(str = properties.getProperty("version", "").trim()).isEmpty())
/* 257 */           return str;  }
/*     */       catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/*     */       finally
/* 260 */       { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }   }  } catch (IOException iOException) {}
/*     */ 
/*     */     
/*     */     Package package_;
/*     */ 
/*     */     
/* 266 */     if ((package_ = clazz.getPackage()) != null) {
/*     */       String str;
/* 268 */       if ((str = package_.getImplementationVersion()) == null) {
/* 269 */         str = "";
/*     */       }
/*     */       
/* 272 */       if ((str = str.trim()).isEmpty()) {
/*     */         
/* 274 */         if ((str = package_.getSpecificationVersion()) == null) {
/* 275 */           str = "";
/*     */         }
/* 277 */         str = str.trim();
/*     */       } 
/* 279 */       if (!str.isEmpty()) {
/* 280 */         return str;
/*     */       }
/*     */     } 
/* 283 */     return "unknown";
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
/*     */   private static DocumentBuilderFactory getSecureDocumentBuilderFactory() {
/*     */     DocumentBuilderFactory documentBuilderFactory;
/* 298 */     (documentBuilderFactory = DocumentBuilderFactory.newInstance()).setXIncludeAware(false);
/* 299 */     documentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
/* 300 */     documentBuilderFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
/* 301 */     documentBuilderFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalSchema", "");
/* 302 */     documentBuilderFactory.setExpandEntityReferences(false);
/* 303 */     documentBuilderFactory.setNamespaceAware(true);
/* 304 */     documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
/* 305 */     documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
/* 306 */     documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
/* 307 */     documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
/* 308 */     return documentBuilderFactory;
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
/*     */   private static XPathFactory getSecureXPathFactory() {
/*     */     XPathFactory xPathFactory;
/* 321 */     (xPathFactory = XPathFactory.newInstance()).setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
/* 322 */     return xPathFactory;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\VersionFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */