/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
/*     */ import nonapi.io.github.classgraph.utils.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModulePathInfo
/*     */ {
/*  57 */   public final Set<String> modulePath = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public final Set<String> addModules = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public final Set<String> patchModules = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public final Set<String> addExports = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public final Set<String> addOpens = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public final Set<String> addReads = new LinkedHashSet<>();
/*     */ 
/*     */   
/* 101 */   private final List<Set<String>> fields = Arrays.asList((Set<String>[])new Set[] { this.modulePath, this.addModules, this.patchModules, this.addExports, this.addOpens, this.addReads });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   private static final List<String> argSwitches = Arrays.asList(new String[] { "--module-path=", "--add-modules=", "--patch-module=", "--add-exports=", "--add-opens=", "--add-reads=" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   private static final List<Character> argPartSeparatorChars = Arrays.asList(new Character[] {
/* 122 */         Character.valueOf(File.pathSeparatorChar), 
/* 123 */         Character.valueOf(','), 
/* 124 */         Character.valueOf(false), 
/* 125 */         Character.valueOf(false), 
/* 126 */         Character.valueOf(false), 
/* 127 */         Character.valueOf(false)
/*     */       });
/*     */ 
/*     */   
/* 131 */   private final AtomicBoolean gotRuntimeInfo = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void getRuntimeInfo(ReflectionUtils paramReflectionUtils) {
/* 137 */     if (!this.gotRuntimeInfo.getAndSet(true)) {
/*     */       List list;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Class clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       if ((list = (List)(((object = ((clazz = paramReflectionUtils.classForNameOrNull("java.lang.management.ManagementFactory")) == null) ? null : paramReflectionUtils.invokeStaticMethod(false, clazz, "getRuntimeMXBean")) == null) ? null : paramReflectionUtils.invokeMethod(false, object, "getInputArguments"))) != null) {
/* 152 */         for (Object object : list) {
/* 153 */           for (byte b = 0; b < this.fields.size(); b++) {
/* 154 */             String str = argSwitches.get(b);
/* 155 */             if (object.startsWith(str)) {
/* 156 */               str = object.substring(str.length());
/* 157 */               Set<String> set = this.fields.get(b);
/*     */               char c;
/* 159 */               if ((c = ((Character)argPartSeparatorChars.get(b)).charValue()) == '\000') {
/*     */                 
/* 161 */                 set.add(str);
/*     */               } else {
/*     */                 
/* 164 */                 set.addAll(
/* 165 */                     Arrays.asList(JarUtils.smartPathSplit(str, c, null)));
/*     */               } 
/*     */             } 
/*     */           } 
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
/*     */   public String toString() {
/* 181 */     StringBuilder stringBuilder = new StringBuilder(1024);
/* 182 */     if (!this.modulePath.isEmpty()) {
/* 183 */       stringBuilder.append("--module-path=");
/* 184 */       stringBuilder.append(StringUtils.join(File.pathSeparator, this.modulePath));
/*     */     } 
/* 186 */     if (!this.addModules.isEmpty()) {
/* 187 */       if (stringBuilder.length() > 0) {
/* 188 */         stringBuilder.append(' ');
/*     */       }
/* 190 */       stringBuilder.append("--add-modules=");
/* 191 */       stringBuilder.append(StringUtils.join(",", this.addModules));
/*     */     } 
/* 193 */     for (String str : this.patchModules) {
/* 194 */       if (stringBuilder.length() > 0) {
/* 195 */         stringBuilder.append(' ');
/*     */       }
/* 197 */       stringBuilder.append("--patch-module=");
/* 198 */       stringBuilder.append(str);
/*     */     } 
/* 200 */     for (String str : this.addExports) {
/* 201 */       if (stringBuilder.length() > 0) {
/* 202 */         stringBuilder.append(' ');
/*     */       }
/* 204 */       stringBuilder.append("--add-exports=");
/* 205 */       stringBuilder.append(str);
/*     */     } 
/* 207 */     for (String str : this.addOpens) {
/* 208 */       if (stringBuilder.length() > 0) {
/* 209 */         stringBuilder.append(' ');
/*     */       }
/* 211 */       stringBuilder.append("--add-opens=");
/* 212 */       stringBuilder.append(str);
/*     */     } 
/* 214 */     for (String str : this.addReads) {
/* 215 */       if (stringBuilder.length() > 0) {
/* 216 */         stringBuilder.append(' ');
/*     */       }
/* 218 */       stringBuilder.append("--add-reads=");
/* 219 */       stringBuilder.append(str);
/*     */     } 
/* 221 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ModulePathInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */