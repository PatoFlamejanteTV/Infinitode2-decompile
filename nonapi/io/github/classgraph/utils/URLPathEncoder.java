/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.StandardCharsets;
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
/*     */ public final class URLPathEncoder
/*     */ {
/*  41 */   private static boolean[] safe = new boolean[256];
/*     */   static {
/*     */     byte b;
/*  44 */     for (b = 97; b <= 122; b++) {
/*  45 */       safe[b] = true;
/*     */     }
/*  47 */     for (b = 65; b <= 90; b++) {
/*  48 */       safe[b] = true;
/*     */     }
/*  50 */     for (b = 48; b <= 57; b++) {
/*  51 */       safe[b] = true;
/*     */     }
/*     */     
/*  54 */     safe[43] = true; safe[46] = true; safe[95] = true; safe[45] = true; safe[36] = true;
/*     */     
/*  56 */     safe[44] = true; safe[41] = true; safe[40] = true; safe[39] = true; safe[42] = true; safe[33] = true;
/*     */     
/*  58 */     safe[47] = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static final char[] HEXADECIMAL = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */ 
/*     */   
/*  68 */   private static final String[] SCHEME_PREFIXES = new String[] { "jrt:", "file:", "jar:file:", "jar:", "http:", "https:" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void unescapeChars(String paramString, boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream) {
/*  79 */     if (paramString.isEmpty())
/*     */       return;  byte b;
/*     */     int i;
/*  82 */     for (b = 0, i = paramString.length(); b < i; b++) {
/*     */       char c;
/*  84 */       if ((c = paramString.charAt(b)) == '%') {
/*     */         
/*  86 */         if (b <= i - 3) {
/*     */ 
/*     */ 
/*     */           
/*  90 */           c = ((c = paramString.charAt(++b)) >= '0' && c <= '9') ? (c - 48) : ((c >= 'a' && c <= 'f') ? (c - 97 + 10) : ((c >= 'A' && c <= 'F') ? (c - 65 + 10) : -1));
/*     */ 
/*     */ 
/*     */           
/*  94 */           char c1 = ((c1 = paramString.charAt(++b)) >= '0' && c1 <= '9') ? (c1 - 48) : ((c1 >= 'a' && c1 <= 'f') ? (c1 - 97 + 10) : ((c1 >= 'A' && c1 <= 'F') ? (c1 - 65 + 10) : -1));
/*     */ 
/*     */           
/*  97 */           if (c < '\000' || c1 < '\000') {
/*     */             try {
/*  99 */               paramByteArrayOutputStream.write(paramString.substring(b - 2, b + 1).getBytes(StandardCharsets.UTF_8));
/* 100 */             } catch (IOException iOException) {}
/*     */           }
/*     */           else {
/*     */             
/* 104 */             paramByteArrayOutputStream.write((byte)(c << 4 | c1));
/*     */           } 
/*     */         } 
/* 107 */       } else if (paramBoolean && c == '+') {
/* 108 */         paramByteArrayOutputStream.write(32);
/* 109 */       } else if (c <= '') {
/* 110 */         paramByteArrayOutputStream.write((byte)c);
/*     */       } else {
/*     */         try {
/* 113 */           paramByteArrayOutputStream.write(Character.toString(c).getBytes(StandardCharsets.UTF_8));
/* 114 */         } catch (IOException iOException) {}
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static String decodePath(String paramString) {
/*     */     int i;
/* 130 */     String str = ((i = paramString.indexOf('?')) < 0) ? paramString : paramString.substring(0, i);
/* 131 */     paramString = (i < 0) ? "" : paramString.substring(i);
/* 132 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 133 */     unescapeChars(str, false, byteArrayOutputStream);
/* 134 */     unescapeChars(paramString, true, byteArrayOutputStream);
/* 135 */     return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
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
/*     */   public static String encodePath(String paramString) {
/* 147 */     int i = 0; String[] arrayOfString; byte b;
/* 148 */     for (int j = (arrayOfString = SCHEME_PREFIXES).length; b < j; ) { String str = arrayOfString[b];
/* 149 */       if (paramString.startsWith(str)) {
/* 150 */         i = str.length();
/*     */         break;
/*     */       } 
/*     */       b++; }
/*     */     
/* 155 */     if (VersionFinder.OS == VersionFinder.OperatingSystem.Windows) {
/*     */       int k;
/* 157 */       if ((k = i) < paramString.length() && paramString.charAt(k) == '/') {
/* 158 */         k++;
/*     */       }
/* 160 */       if (k < paramString.length() - 1 && Character.isLetter(paramString.charAt(k)) && paramString.charAt(k + 1) == ':') {
/* 161 */         i = k + 2;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 166 */     byte[] arrayOfByte = paramString.getBytes(StandardCharsets.UTF_8);
/* 167 */     StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length * 3);
/* 168 */     for (b = 0; b < arrayOfByte.length; b++) {
/*     */       byte b1;
/* 170 */       int k = (b1 = arrayOfByte[b]) & 0xFF;
/* 171 */       if (safe[k] || (k == 58 && b < i)) {
/* 172 */         stringBuilder.append((char)k);
/*     */       } else {
/* 174 */         stringBuilder.append('%');
/* 175 */         stringBuilder.append(HEXADECIMAL[(k & 0xF0) >> 4]);
/* 176 */         stringBuilder.append(HEXADECIMAL[k & 0xF]);
/*     */       } 
/*     */     } 
/* 179 */     return stringBuilder.toString();
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
/*     */   public static String normalizeURLPath(String paramString) {
/* 191 */     if (!(paramString = paramString).startsWith("jrt:") && !paramString.startsWith("http://") && 
/* 192 */       !paramString.startsWith("https://")) {
/*     */ 
/*     */       
/* 195 */       if (paramString.startsWith("jar:")) {
/* 196 */         paramString = paramString.substring(4);
/*     */       }
/* 198 */       if (paramString.startsWith("file:")) {
/* 199 */         paramString = paramString.substring(4);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 204 */       String str = "";
/* 205 */       if (VersionFinder.OS == VersionFinder.OperatingSystem.Windows) {
/* 206 */         if (paramString.length() >= 2 && Character.isLetter(paramString.charAt(0)) && paramString
/* 207 */           .charAt(1) == ':') {
/*     */           
/* 209 */           str = paramString.substring(0, 2);
/* 210 */           paramString = paramString.substring(2);
/* 211 */         } else if (paramString.length() >= 3 && paramString.charAt(0) == '/' && 
/* 212 */           Character.isLetter(paramString.charAt(1)) && paramString.charAt(2) == ':') {
/*     */           
/* 214 */           str = paramString.substring(1, 3);
/* 215 */           paramString = paramString.substring(3);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 220 */       paramString = paramString.replace("/!", "!").replace("!/", "!").replace("!", "!/");
/*     */ 
/*     */       
/* 223 */       if (str.isEmpty()) {
/*     */         
/* 225 */         paramString = paramString.startsWith("/") ? ("file:" + paramString) : ("file:/" + paramString);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 230 */         paramString = "file:/" + str + (paramString.startsWith("/") ? paramString : ("/" + paramString));
/*     */       } 
/*     */ 
/*     */       
/* 234 */       if (paramString.contains("!") && !paramString.startsWith("jar:")) {
/* 235 */         paramString = "jar:" + paramString;
/*     */       }
/*     */     } 
/* 238 */     return encodePath(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\URLPathEncoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */