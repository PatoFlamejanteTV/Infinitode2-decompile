/*     */ package org.jsoup.helper;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.CharArrayReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.IllegalCharsetNameException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import org.jsoup.internal.ControllableInputStream;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.XmlDeclaration;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.select.Elements;
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
/*     */ public final class DataUtil
/*     */ {
/*  44 */   private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
/*     */   public static final Charset UTF_8;
/*  46 */   static final String defaultCharsetName = (UTF_8 = Charset.forName("UTF-8")).name();
/*     */   private static final int firstReadBufferSize = 5120;
/*  48 */   private static final char[] mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
/*  49 */     .toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int boundaryLength = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document load(File paramFile, String paramString1, String paramString2) {
/*  66 */     return load(paramFile, paramString1, paramString2, Parser.htmlParser());
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
/*     */   public static Document load(File paramFile, String paramString1, String paramString2, Parser paramParser) {
/*  84 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     String str;
/*  86 */     if ((str = Normalizer.lowerCase(paramFile.getName())).endsWith(".gz") || str.endsWith(".z")) {
/*     */       boolean bool;
/*     */       
/*     */       try {
/*  90 */         bool = (fileInputStream.read() == 31 && fileInputStream.read() == 139) ? true : false;
/*     */       } finally {
/*  92 */         fileInputStream.close();
/*     */       } 
/*     */       
/*  95 */       fileInputStream = bool ? (FileInputStream)new GZIPInputStream(new FileInputStream(paramFile)) : new FileInputStream(paramFile);
/*     */     } 
/*  97 */     return parseInputStream(fileInputStream, paramString1, paramString2, paramParser);
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
/*     */   public static Document load(InputStream paramInputStream, String paramString1, String paramString2) {
/* 109 */     return parseInputStream(paramInputStream, paramString1, paramString2, Parser.htmlParser());
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
/*     */   public static Document load(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser) {
/* 122 */     return parseInputStream(paramInputStream, paramString1, paramString2, paramParser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void crossStreams(InputStream paramInputStream, OutputStream paramOutputStream) {
/* 132 */     byte[] arrayOfByte = new byte[32768];
/*     */     int i;
/* 134 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 135 */       paramOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/*     */   }
/*     */   
/*     */   static Document parseInputStream(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser) {
/* 140 */     if (paramInputStream == null)
/* 141 */       return new Document(paramString2); 
/* 142 */     ControllableInputStream controllableInputStream = ControllableInputStream.wrap(paramInputStream, 32768, 0);
/*     */     
/* 144 */     Document document = null;
/*     */ 
/*     */     
/*     */     try {
/* 148 */       controllableInputStream.mark(32768);
/* 149 */       ByteBuffer byteBuffer = readToByteBuffer((InputStream)controllableInputStream, 5119);
/* 150 */       boolean bool = (controllableInputStream.read() == -1) ? true : false;
/* 151 */       controllableInputStream.reset();
/*     */       
/*     */       BomCharset bomCharset;
/*     */       
/* 155 */       if ((bomCharset = detectCharsetFromBom(byteBuffer)) != null) {
/* 156 */         paramString1 = bomCharset.charset;
/*     */       }
/* 158 */       if (paramString1 == null) {
/*     */         try {
/*     */           CharBuffer charBuffer;
/* 161 */           if ((charBuffer = UTF_8.decode(byteBuffer)).hasArray())
/* 162 */           { document = paramParser.parseInput(new CharArrayReader(charBuffer.array(), charBuffer.arrayOffset(), charBuffer.limit()), paramString2); }
/*     */           else
/* 164 */           { document = paramParser.parseInput(charBuffer.toString(), paramString2); } 
/* 165 */         } catch (UncheckedIOException uncheckedIOException) {
/* 166 */           throw (byteBuffer = null).getCause();
/*     */         } 
/*     */ 
/*     */         
/* 170 */         Elements elements = document.select("meta[http-equiv=content-type], meta[charset]");
/* 171 */         String str = null;
/* 172 */         for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext(); ) {
/* 173 */           Element element; if ((element = iterator.next()).hasAttr("http-equiv"))
/* 174 */             str = getCharsetFromContentType(element.attr("content")); 
/* 175 */           if (str == null && element.hasAttr("charset"))
/* 176 */             str = element.attr("charset"); 
/* 177 */           if (str == null);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 182 */         if (str == null && document.childNodeSize() > 0) {
/* 183 */           XmlDeclaration xmlDeclaration; Node node = document.childNode(0);
/* 184 */           elements = null;
/* 185 */           if (node instanceof XmlDeclaration)
/* 186 */           { xmlDeclaration = (XmlDeclaration)node; }
/* 187 */           else { Comment comment; if (node instanceof Comment && (
/*     */               
/* 189 */               comment = (Comment)node).isXmlDeclaration())
/* 190 */               xmlDeclaration = comment.asXmlDeclaration();  }
/*     */           
/* 192 */           if (xmlDeclaration != null && 
/* 193 */             xmlDeclaration.name().equalsIgnoreCase("xml")) {
/* 194 */             str = xmlDeclaration.attr("encoding");
/*     */           }
/*     */         } 
/*     */         
/* 198 */         if ((str = validateCharset(str)) != null && !str.equalsIgnoreCase(defaultCharsetName)) {
/*     */           
/* 200 */           paramString1 = str = str.trim().replaceAll("[\"']", "");
/* 201 */           document = null;
/* 202 */         } else if (!bool) {
/* 203 */           document = null;
/*     */         } 
/*     */       } else {
/* 206 */         Validate.notEmpty(paramString1, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
/*     */       } 
/* 208 */       if (document == null) {
/* 209 */         if (paramString1 == null)
/* 210 */           paramString1 = defaultCharsetName; 
/* 211 */         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)controllableInputStream, Charset.forName(paramString1)), 32768);
/*     */         try {
/* 213 */           if (bomCharset != null && bomCharset.offset) {
/*     */             long l;
/* 215 */             Validate.isTrue(((l = bufferedReader.skip(1L)) == 1L));
/*     */           } 
/*     */           try {
/* 218 */             document = paramParser.parseInput(bufferedReader, paramString2);
/* 219 */           } catch (UncheckedIOException uncheckedIOException2) {
/*     */             UncheckedIOException uncheckedIOException1;
/* 221 */             throw (uncheckedIOException1 = null).getCause();
/*     */           } 
/* 223 */           Charset charset = paramString1.equals(defaultCharsetName) ? UTF_8 : Charset.forName(paramString1);
/* 224 */           document.outputSettings().charset(charset);
/* 225 */           if (!charset.canEncode())
/*     */           {
/* 227 */             document.charset(UTF_8);
/*     */           }
/*     */         } finally {
/*     */           
/* 231 */           bufferedReader.close();
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       
/* 236 */       controllableInputStream.close();
/*     */     } 
/* 238 */     return document;
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
/*     */   public static ByteBuffer readToByteBuffer(InputStream paramInputStream, int paramInt) {
/* 250 */     return ControllableInputStream.readToByteBuffer(paramInputStream, paramInt);
/*     */   }
/*     */   
/*     */   static ByteBuffer emptyByteBuffer() {
/* 254 */     return ByteBuffer.allocate(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getCharsetFromContentType(String paramString) {
/* 264 */     if (paramString == null) return null; 
/*     */     Matcher matcher;
/* 266 */     if ((matcher = charsetPattern.matcher(paramString)).find()) {
/*     */       String str;
/*     */       
/* 269 */       return validateCharset(str = (str = matcher.group(1).trim()).replace("charset=", ""));
/*     */     } 
/* 271 */     return null;
/*     */   }
/*     */   
/*     */   private static String validateCharset(String paramString) {
/* 275 */     if (paramString == null || paramString.length() == 0) return null; 
/* 276 */     paramString = paramString.trim().replaceAll("[\"']", "");
/*     */     try {
/* 278 */       if (Charset.isSupported(paramString)) return paramString;
/*     */       
/* 280 */       if (Charset.isSupported(paramString = paramString.toUpperCase(Locale.ENGLISH))) return paramString; 
/* 281 */     } catch (IllegalCharsetNameException illegalCharsetNameException) {}
/*     */ 
/*     */     
/* 284 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String mimeBoundary() {
/* 291 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 292 */     Random random = new Random();
/* 293 */     for (byte b = 0; b < 32; b++) {
/* 294 */       stringBuilder.append(mimeBoundaryChars[random.nextInt(mimeBoundaryChars.length)]);
/*     */     }
/* 296 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */   
/*     */   private static BomCharset detectCharsetFromBom(ByteBuffer paramByteBuffer) {
/*     */     ByteBuffer byteBuffer;
/* 301 */     (byteBuffer = paramByteBuffer).mark();
/* 302 */     byte[] arrayOfByte = new byte[4];
/* 303 */     if (paramByteBuffer.remaining() >= 4) {
/* 304 */       paramByteBuffer.get(arrayOfByte);
/* 305 */       byteBuffer.rewind();
/*     */     } 
/* 307 */     if ((arrayOfByte[0] == 0 && arrayOfByte[1] == 0 && arrayOfByte[2] == -2 && arrayOfByte[3] == -1) || (arrayOfByte[0] == -1 && arrayOfByte[1] == -2 && arrayOfByte[2] == 0 && arrayOfByte[3] == 0))
/*     */     {
/* 309 */       return new BomCharset("UTF-32", false); } 
/* 310 */     if ((arrayOfByte[0] == -2 && arrayOfByte[1] == -1) || (arrayOfByte[0] == -1 && arrayOfByte[1] == -2))
/*     */     {
/* 312 */       return new BomCharset("UTF-16", false); } 
/* 313 */     if (arrayOfByte[0] == -17 && arrayOfByte[1] == -69 && arrayOfByte[2] == -65) {
/* 314 */       return new BomCharset("UTF-8", true);
/*     */     }
/*     */     
/* 317 */     return null;
/*     */   }
/*     */   
/*     */   private static class BomCharset {
/*     */     private final String charset;
/*     */     private final boolean offset;
/*     */     
/*     */     public BomCharset(String param1String, boolean param1Boolean) {
/* 325 */       this.charset = param1String;
/* 326 */       this.offset = param1Boolean;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\DataUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */