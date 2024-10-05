/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLVersion
/*     */ {
/*     */   private int majorVersion;
/*     */   private int minorVersion;
/*     */   private int releaseVersion;
/*     */   private final String versionString;
/*     */   private final String vendorString;
/*     */   private final String rendererString;
/*     */   private final Type type;
/*  37 */   private final String TAG = "GLVersion";
/*     */   
/*     */   public GLVersion(Application.ApplicationType paramApplicationType, String paramString1, String paramString2, String paramString3) {
/*  40 */     if (paramApplicationType == Application.ApplicationType.Android) {
/*  41 */       this.type = Type.GLES;
/*  42 */     } else if (paramApplicationType == Application.ApplicationType.iOS) {
/*  43 */       this.type = Type.GLES;
/*  44 */     } else if (paramApplicationType == Application.ApplicationType.Desktop) {
/*  45 */       this.type = Type.OpenGL;
/*  46 */     } else if (paramApplicationType == Application.ApplicationType.Applet) {
/*  47 */       this.type = Type.OpenGL;
/*  48 */     } else if (paramApplicationType == Application.ApplicationType.WebGL) {
/*  49 */       this.type = Type.WebGL;
/*     */     } else {
/*  51 */       this.type = Type.NONE;
/*     */     } 
/*  53 */     if (this.type == Type.GLES) {
/*     */       
/*  55 */       extractVersion("OpenGL ES (\\d(\\.\\d){0,2})", paramString1);
/*  56 */     } else if (this.type == Type.WebGL) {
/*     */       
/*  58 */       extractVersion("WebGL (\\d(\\.\\d){0,2})", paramString1);
/*  59 */     } else if (this.type == Type.OpenGL) {
/*     */       
/*  61 */       extractVersion("(\\d(\\.\\d){0,2})", paramString1);
/*     */     } else {
/*  63 */       this.majorVersion = -1;
/*  64 */       this.minorVersion = -1;
/*  65 */       this.releaseVersion = -1;
/*  66 */       paramString2 = "";
/*  67 */       paramString3 = "";
/*     */     } 
/*  69 */     this.versionString = paramString1;
/*  70 */     this.vendorString = paramString2;
/*  71 */     this.rendererString = paramString3;
/*     */   }
/*     */   
/*     */   private void extractVersion(String paramString1, String paramString2) {
/*     */     Pattern pattern;
/*     */     Matcher matcher;
/*     */     boolean bool;
/*  78 */     if (bool = (matcher = (pattern = Pattern.compile(paramString1)).matcher(paramString2)).find()) {
/*     */       
/*  80 */       String str, arrayOfString[] = (str = matcher.group(1)).split("\\.");
/*  81 */       this.majorVersion = parseInt(arrayOfString[0], 2);
/*  82 */       this.minorVersion = (arrayOfString.length < 2) ? 0 : parseInt(arrayOfString[1], 0);
/*  83 */       this.releaseVersion = (arrayOfString.length < 3) ? 0 : parseInt(arrayOfString[2], 0); return;
/*     */     } 
/*  85 */     Gdx.app.log("GLVersion", "Invalid version string: " + paramString2);
/*  86 */     this.majorVersion = 2;
/*  87 */     this.minorVersion = 0;
/*  88 */     this.releaseVersion = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int parseInt(String paramString, int paramInt) {
/*     */     try {
/*  95 */       return Integer.parseInt(paramString);
/*  96 */     } catch (NumberFormatException numberFormatException) {
/*  97 */       Gdx.app.error("libGDX GL", "Error parsing number: " + paramString + ", assuming: " + paramInt);
/*  98 */       return paramInt;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Type getType() {
/* 105 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMajorVersion() {
/* 110 */     return this.majorVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinorVersion() {
/* 115 */     return this.minorVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getReleaseVersion() {
/* 120 */     return this.releaseVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersionString() {
/* 125 */     return this.versionString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVendorString() {
/* 130 */     return this.vendorString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRendererString() {
/* 136 */     return this.rendererString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVersionEqualToOrHigher(int paramInt1, int paramInt2) {
/* 145 */     return (this.majorVersion > paramInt1 || (this.majorVersion == paramInt1 && this.minorVersion >= paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDebugVersionString() {
/* 150 */     return "Type: " + this.type + "\nVersion: " + this.majorVersion + ":" + this.minorVersion + ":" + this.releaseVersion + "\nVendor: " + this.vendorString + "\nRenderer: " + this.rendererString;
/*     */   }
/*     */   
/*     */   public enum Type
/*     */   {
/* 155 */     OpenGL, GLES, WebGL, NONE;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\GLVersion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */