/*     */ package com.google.common.base;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public enum StandardSystemProperty
/*     */ {
/*  31 */   JAVA_VERSION("java.version"),
/*     */ 
/*     */   
/*  34 */   JAVA_VENDOR("java.vendor"),
/*     */ 
/*     */   
/*  37 */   JAVA_VENDOR_URL("java.vendor.url"),
/*     */ 
/*     */   
/*  40 */   JAVA_HOME("java.home"),
/*     */ 
/*     */   
/*  43 */   JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
/*     */ 
/*     */   
/*  46 */   JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
/*     */ 
/*     */   
/*  49 */   JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
/*     */ 
/*     */   
/*  52 */   JAVA_VM_VERSION("java.vm.version"),
/*     */ 
/*     */   
/*  55 */   JAVA_VM_VENDOR("java.vm.vendor"),
/*     */ 
/*     */   
/*  58 */   JAVA_VM_NAME("java.vm.name"),
/*     */ 
/*     */   
/*  61 */   JAVA_SPECIFICATION_VERSION("java.specification.version"),
/*     */ 
/*     */   
/*  64 */   JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
/*     */ 
/*     */   
/*  67 */   JAVA_SPECIFICATION_NAME("java.specification.name"),
/*     */ 
/*     */   
/*  70 */   JAVA_CLASS_VERSION("java.class.version"),
/*     */ 
/*     */   
/*  73 */   JAVA_CLASS_PATH("java.class.path"),
/*     */ 
/*     */   
/*  76 */   JAVA_LIBRARY_PATH("java.library.path"),
/*     */ 
/*     */   
/*  79 */   JAVA_IO_TMPDIR("java.io.tmpdir"),
/*     */ 
/*     */   
/*  82 */   JAVA_COMPILER("java.compiler"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   JAVA_EXT_DIRS("java.ext.dirs"),
/*     */ 
/*     */ 
/*     */   
/*  96 */   OS_NAME("os.name"),
/*     */ 
/*     */   
/*  99 */   OS_ARCH("os.arch"),
/*     */ 
/*     */   
/* 102 */   OS_VERSION("os.version"),
/*     */ 
/*     */   
/* 105 */   FILE_SEPARATOR("file.separator"),
/*     */ 
/*     */   
/* 108 */   PATH_SEPARATOR("path.separator"),
/*     */ 
/*     */   
/* 111 */   LINE_SEPARATOR("line.separator"),
/*     */ 
/*     */   
/* 114 */   USER_NAME("user.name"),
/*     */ 
/*     */   
/* 117 */   USER_HOME("user.home"),
/*     */ 
/*     */   
/* 120 */   USER_DIR("user.dir");
/*     */   
/*     */   private final String key;
/*     */   
/*     */   StandardSystemProperty(String paramString1) {
/* 125 */     this.key = paramString1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String key() {
/* 130 */     return this.key;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String value() {
/* 158 */     return System.getProperty(this.key);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 164 */     String str1 = key(), str2 = value(); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("=").append(str2).toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\StandardSystemProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */