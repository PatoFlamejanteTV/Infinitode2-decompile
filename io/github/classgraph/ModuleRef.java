/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
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
/*     */ public class ModuleRef
/*     */   implements Comparable<ModuleRef>
/*     */ {
/*     */   private final String name;
/*     */   private final Object reference;
/*     */   private final Object layer;
/*     */   private final Object descriptor;
/*     */   private final List<String> packages;
/*     */   private final URI location;
/*     */   private String locationStr;
/*     */   private File locationFile;
/*     */   private String rawVersion;
/*     */   private final ClassLoader classLoader;
/*     */   ReflectionUtils reflectionUtils;
/*     */   
/*     */   public ModuleRef(Object paramObject1, Object paramObject2, ReflectionUtils paramReflectionUtils) {
/*  87 */     if (paramObject1 == null) {
/*  88 */       throw new IllegalArgumentException("moduleReference cannot be null");
/*     */     }
/*  90 */     if (paramObject2 == null) {
/*  91 */       throw new IllegalArgumentException("moduleLayer cannot be null");
/*     */     }
/*  93 */     this.reference = paramObject1;
/*  94 */     this.layer = paramObject2;
/*  95 */     this.reflectionUtils = paramReflectionUtils;
/*     */     
/*  97 */     this.descriptor = paramReflectionUtils.invokeMethod(true, paramObject1, "descriptor");
/*  98 */     if (this.descriptor == null)
/*     */     {
/* 100 */       throw new IllegalArgumentException("moduleReference.descriptor() should not return null");
/*     */     }
/* 102 */     this.name = (String)paramReflectionUtils.invokeMethod(true, this.descriptor, "name");
/*     */     
/*     */     Set<? extends String> set;
/*     */     
/* 106 */     if ((set = (Set)paramReflectionUtils.invokeMethod(true, this.descriptor, "packages")) == null)
/*     */     {
/* 108 */       throw new IllegalArgumentException("moduleReference.descriptor().packages() should not return null");
/*     */     }
/* 110 */     this.packages = new ArrayList<>(set);
/* 111 */     CollectionUtils.sortIfNotEmpty(this.packages);
/*     */     Object object1;
/*     */     Boolean bool;
/* 114 */     if ((object1 = paramReflectionUtils.invokeMethod(true, this.descriptor, "rawVersion")) != null && (
/*     */ 
/*     */       
/* 117 */       bool = (Boolean)paramReflectionUtils.invokeMethod(true, object1, "isPresent")) != null && bool.booleanValue()) {
/* 118 */       this.rawVersion = (String)paramReflectionUtils.invokeMethod(true, object1, "get");
/*     */     }
/*     */ 
/*     */     
/*     */     Object object2;
/*     */     
/* 124 */     if ((object2 = paramReflectionUtils.invokeMethod(true, paramObject1, "location")) == null)
/*     */     {
/* 126 */       throw new IllegalArgumentException("moduleReference.location() should not return null");
/*     */     }
/*     */ 
/*     */     
/* 130 */     if ((paramObject1 = paramReflectionUtils.invokeMethod(true, object2, "isPresent")) == null)
/*     */     {
/* 132 */       throw new IllegalArgumentException("moduleReference.location().isPresent() should not return null");
/*     */     }
/* 134 */     if (((Boolean)paramObject1).booleanValue()) {
/* 135 */       this.location = (URI)paramReflectionUtils.invokeMethod(true, object2, "get");
/*     */       
/* 137 */       if (this.location == null)
/*     */       {
/* 139 */         throw new IllegalArgumentException("moduleReference.location().get() should not return null");
/*     */       }
/*     */     } else {
/* 142 */       this.location = null;
/*     */     } 
/*     */ 
/*     */     
/* 146 */     this.classLoader = (ClassLoader)paramReflectionUtils.invokeMethod(true, paramObject2, "findLoader", String.class, this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 156 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getReference() {
/* 165 */     return this.reference;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getLayer() {
/* 174 */     return this.layer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDescriptor() {
/* 183 */     return this.descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getPackages() {
/* 192 */     return this.packages;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getLocation() {
/* 203 */     return this.location;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocationStr() {
/* 214 */     if (this.locationStr == null && this.location != null) {
/* 215 */       this.locationStr = this.location.toString();
/*     */     }
/* 217 */     return this.locationStr;
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
/*     */   public File getLocationFile() {
/* 229 */     if (this.locationFile == null && this.location != null && "file".equals(this.location.getScheme())) {
/* 230 */       this.locationFile = new File(this.location);
/*     */     }
/* 232 */     return this.locationFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRawVersion() {
/* 241 */     return this.rawVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSystemModule() {
/* 250 */     if (this.name == null || this.name.isEmpty()) {
/* 251 */       return false;
/*     */     }
/* 253 */     if (this.name.startsWith("java.") || this.name.startsWith("jdk.") || this.name.startsWith("javafx.") || this.name
/* 254 */       .startsWith("oracle.")) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoader getClassLoader() {
/* 264 */     return this.classLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 272 */     if (paramObject == this)
/* 273 */       return true; 
/* 274 */     if (!(paramObject instanceof ModuleRef)) {
/* 275 */       return false;
/*     */     }
/*     */     
/* 278 */     if (((ModuleRef)(paramObject = paramObject)).reference.equals(this.reference) && ((ModuleRef)paramObject).layer.equals(this.layer)) return true;  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 286 */     return this.reference.hashCode() * this.layer.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 294 */     return this.reference.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ModuleRef paramModuleRef) {
/*     */     int i;
/* 303 */     return ((i = this.name.compareTo(paramModuleRef.name)) != 0) ? i : (hashCode() - paramModuleRef.hashCode());
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
/*     */   public ModuleReaderProxy open() {
/* 316 */     return new ModuleReaderProxy(this);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ModuleRef.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */