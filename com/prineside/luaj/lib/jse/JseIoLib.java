/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.prineside.luaj.Globals;
/*     */ import com.prineside.luaj.LuaError;
/*     */ import com.prineside.luaj.LuaString;
/*     */ import com.prineside.luaj.lib.IoLib;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.RandomAccessFile;
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
/*     */ public class JseIoLib
/*     */   extends IoLib
/*     */ {
/*     */   protected final IoLib.File d() {
/*  72 */     return new StdinFile((byte)0);
/*     */   }
/*     */   
/*     */   protected final IoLib.File e() {
/*  76 */     return new StdoutFile(1, (byte)0);
/*     */   }
/*     */   
/*     */   protected final IoLib.File f() {
/*  80 */     return new StdoutFile(2, (byte)0);
/*     */   }
/*     */   
/*     */   protected final IoLib.File a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  84 */     RandomAccessFile randomAccessFile = new RandomAccessFile(paramString, paramBoolean1 ? "r" : "rw");
/*  85 */     if (paramBoolean2) {
/*  86 */       randomAccessFile.seek(randomAccessFile.length());
/*     */     }
/*  88 */     else if (!paramBoolean1) {
/*  89 */       randomAccessFile.setLength(0L);
/*     */     } 
/*  91 */     return new FileImpl(randomAccessFile, (byte)0);
/*     */   }
/*     */   
/*     */   protected final IoLib.File b(String paramString1, String paramString2) {
/*  95 */     Process process = Runtime.getRuntime().exec(paramString1);
/*  96 */     if ("w".equals(paramString2))
/*  97 */       return new FileImpl(process.getOutputStream(), (byte)0); 
/*  98 */     return new FileImpl(process.getInputStream(), (byte)0);
/*     */   }
/*     */   
/*     */   protected final IoLib.File g() {
/*     */     File file;
/* 103 */     (file = File.createTempFile(".luaj", "bin")).deleteOnExit();
/* 104 */     return new FileImpl(new RandomAccessFile(file, "rw"), (byte)0);
/*     */   }
/*     */   
/*     */   private static void i() {
/* 108 */     throw new LuaError("not implemented");
/*     */   }
/*     */ 
/*     */   
/*     */   private final class FileImpl
/*     */     extends IoLib.File
/*     */   {
/*     */     private final RandomAccessFile a;
/*     */     
/*     */     private final InputStream b;
/*     */     
/*     */     private final OutputStream c;
/*     */     private boolean d = false;
/*     */     private boolean e = false;
/*     */     
/*     */     private FileImpl(RandomAccessFile param1RandomAccessFile) {
/* 124 */       this(param1RandomAccessFile, (InputStream)null, (OutputStream)null);
/*     */     }
/*     */     private FileImpl(InputStream param1InputStream) {
/* 127 */       this((RandomAccessFile)null, param1InputStream, (OutputStream)null);
/*     */     }
/*     */     private FileImpl(OutputStream param1OutputStream) {
/* 130 */       this((RandomAccessFile)null, (InputStream)null, param1OutputStream);
/*     */     }
/*     */     public final String tojstring() {
/* 133 */       return "file (" + (this.d ? "closed" : String.valueOf(hashCode())) + ")";
/*     */     }
/*     */     public final boolean isstdfile() {
/* 136 */       return (this.a == null);
/*     */     }
/*     */     public final void close() {
/* 139 */       this.d = true;
/* 140 */       if (this.a != null)
/* 141 */         this.a.close(); 
/*     */     }
/*     */     
/*     */     public final void flush() {
/* 145 */       if (this.c != null)
/* 146 */         this.c.flush(); 
/*     */     }
/*     */     public final void write(LuaString param1LuaString) {
/* 149 */       if (this.c != null) {
/* 150 */         this.c.write(param1LuaString.m_bytes, param1LuaString.m_offset, param1LuaString.m_length);
/* 151 */       } else if (this.a != null) {
/* 152 */         this.a.write(param1LuaString.m_bytes, param1LuaString.m_offset, param1LuaString.m_length);
/*     */       } else {
/* 154 */         JseIoLib.h();
/* 155 */       }  if (this.e)
/* 156 */         flush(); 
/*     */     }
/*     */     public final boolean isclosed() {
/* 159 */       return this.d;
/*     */     }
/*     */     public final int seek(String param1String, int param1Int) {
/* 162 */       if (this.a != null) {
/* 163 */         if ("set".equals(param1String)) {
/* 164 */           this.a.seek(param1Int);
/* 165 */         } else if ("end".equals(param1String)) {
/* 166 */           this.a.seek(this.a.length() + param1Int);
/*     */         } else {
/* 168 */           this.a.seek(this.a.getFilePointer() + param1Int);
/*     */         } 
/* 170 */         return (int)this.a.getFilePointer();
/*     */       } 
/* 172 */       JseIoLib.h();
/* 173 */       return 0;
/*     */     }
/*     */     public final void setvbuf(String param1String, int param1Int) {
/* 176 */       this.e = "no".equals(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final int remaining() {
/* 181 */       return (this.a != null) ? (int)(this.a.length() - this.a.getFilePointer()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int peek() {
/* 186 */       if (this.b != null) {
/* 187 */         this.b.mark(1);
/* 188 */         int i = this.b.read();
/* 189 */         this.b.reset();
/* 190 */         return i;
/* 191 */       }  if (this.a != null) {
/* 192 */         long l = this.a.getFilePointer();
/* 193 */         int i = this.a.read();
/* 194 */         this.a.seek(l);
/* 195 */         return i;
/*     */       } 
/* 197 */       JseIoLib.h();
/* 198 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int read() {
/* 203 */       if (this.b != null)
/* 204 */         return this.b.read(); 
/* 205 */       if (this.a != null) {
/* 206 */         return this.a.read();
/*     */       }
/* 208 */       JseIoLib.h();
/* 209 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 214 */       if (this.a != null)
/* 215 */         return this.a.read(param1ArrayOfbyte, param1Int1, param1Int2); 
/* 216 */       if (this.b != null) {
/* 217 */         return this.b.read(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */       }
/* 219 */       JseIoLib.h();
/*     */       
/* 221 */       return param1Int2;
/*     */     } private FileImpl(JseIoLib this$0, RandomAccessFile param1RandomAccessFile, InputStream param1InputStream, OutputStream param1OutputStream) {
/*     */       super(JseIoLib.this);
/*     */       this.a = param1RandomAccessFile;
/*     */       this.b = (param1InputStream != null) ? (param1InputStream.markSupported() ? param1InputStream : new BufferedInputStream(param1InputStream)) : null;
/*     */       this.c = param1OutputStream;
/*     */     } } private final class StdoutFile extends IoLib.File { private StdoutFile(JseIoLib this$0, int param1Int) {
/* 228 */       super(JseIoLib.this);
/* 229 */       this.a = param1Int;
/*     */     }
/*     */     private final int a;
/*     */     public final String tojstring() {
/* 233 */       return "file (" + hashCode() + ")";
/*     */     }
/*     */     
/*     */     private final PrintStream d() {
/* 237 */       if (this.a == 2)
/* 238 */         return (JseIoLib.a(this.b)).STDERR; 
/* 239 */       return (JseIoLib.b(this.b)).STDOUT;
/*     */     }
/*     */     
/*     */     public final void write(LuaString param1LuaString) {
/* 243 */       d().write(param1LuaString.m_bytes, param1LuaString.m_offset, param1LuaString.m_length);
/*     */     }
/*     */     
/*     */     public final void flush() {
/* 247 */       d().flush();
/*     */     }
/*     */     
/*     */     public final boolean isstdfile() {
/* 251 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void close() {}
/*     */ 
/*     */     
/*     */     public final boolean isclosed() {
/* 259 */       return false;
/*     */     }
/*     */     
/*     */     public final int seek(String param1String, int param1Int) {
/* 263 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void setvbuf(String param1String, int param1Int) {}
/*     */     
/*     */     public final int remaining() {
/* 270 */       return 0;
/*     */     }
/*     */     
/*     */     public final int peek() {
/* 274 */       return 0;
/*     */     }
/*     */     
/*     */     public final int read() {
/* 278 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 283 */       return 0;
/*     */     } }
/*     */   
/*     */   private final class StdinFile extends IoLib.File {
/*     */     private StdinFile(JseIoLib this$0) {
/* 288 */       super(JseIoLib.this);
/*     */     }
/*     */     
/*     */     public final String tojstring() {
/* 292 */       return "file (" + hashCode() + ")";
/*     */     }
/*     */ 
/*     */     
/*     */     public final void write(LuaString param1LuaString) {}
/*     */ 
/*     */     
/*     */     public final void flush() {}
/*     */     
/*     */     public final boolean isstdfile() {
/* 302 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void close() {}
/*     */ 
/*     */     
/*     */     public final boolean isclosed() {
/* 310 */       return false;
/*     */     }
/*     */     
/*     */     public final int seek(String param1String, int param1Int) {
/* 314 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void setvbuf(String param1String, int param1Int) {}
/*     */     
/*     */     public final int remaining() {
/* 321 */       return -1;
/*     */     }
/*     */     
/*     */     public final int peek() {
/* 325 */       (JseIoLib.c(this.a)).STDIN.mark(1);
/* 326 */       int i = (JseIoLib.d(this.a)).STDIN.read();
/* 327 */       (JseIoLib.e(this.a)).STDIN.reset();
/* 328 */       return i;
/*     */     }
/*     */     
/*     */     public final int read() {
/* 332 */       return (JseIoLib.f(this.a)).STDIN.read();
/*     */     }
/*     */ 
/*     */     
/*     */     public final int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 337 */       return (JseIoLib.g(this.a)).STDIN.read(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseIoLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */