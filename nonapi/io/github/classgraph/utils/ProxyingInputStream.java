/*     */ package nonapi.io.github.classgraph.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProxyingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private InputStream inputStream;
/*     */   private static Method readAllBytes;
/*     */   private static Method readNBytes1;
/*     */   private static Method readNBytes3;
/*     */   private static Method skipNBytes;
/*     */   private static Method transferTo;
/*     */   
/*     */   static {
/*     */     try {
/*  53 */       readAllBytes = InputStream.class.getDeclaredMethod("readAllBytes", new Class[0]);
/*  54 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {}
/*     */ 
/*     */     
/*     */     try {
/*  58 */       readNBytes1 = InputStream.class.getDeclaredMethod("readNBytes", new Class[] { int.class });
/*  59 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {}
/*     */ 
/*     */     
/*     */     try {
/*  63 */       readNBytes3 = InputStream.class.getDeclaredMethod("readNBytes", new Class[] { byte[].class, int.class, int.class });
/*  64 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {}
/*     */ 
/*     */     
/*     */     try {
/*  68 */       skipNBytes = InputStream.class.getDeclaredMethod("skipNBytes", new Class[] { long.class });
/*  69 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {}
/*     */ 
/*     */     
/*     */     try {
/*  73 */       transferTo = InputStream.class.getDeclaredMethod("transferTo", new Class[] { OutputStream.class }); return;
/*  74 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {
/*     */       return;
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
/*     */   public ProxyingInputStream(InputStream paramInputStream) {
/*  87 */     this.inputStream = paramInputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() {
/*  92 */     return this.inputStream.read();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/*  97 */     return this.inputStream.read(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 102 */     return this.inputStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] readAllBytes() {
/* 107 */     if (readAllBytes == null) {
/* 108 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     try {
/* 111 */       return (byte[])readAllBytes.invoke(this.inputStream, new Object[0]);
/* 112 */     } catch (Exception exception) {
/* 113 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] readNBytes(int paramInt) {
/* 119 */     if (readNBytes1 == null) {
/* 120 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     try {
/* 123 */       return (byte[])readNBytes1.invoke(this.inputStream, new Object[] { Integer.valueOf(paramInt) });
/* 124 */     } catch (Exception exception) {
/* 125 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int readNBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 131 */     if (readNBytes3 == null) {
/* 132 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     try {
/* 135 */       return ((Integer)readNBytes3.invoke(this.inputStream, new Object[] { paramArrayOfbyte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })).intValue();
/* 136 */     } catch (Exception exception) {
/* 137 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 143 */     return this.inputStream.available();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 148 */     return this.inputStream.markSupported();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 153 */     this.inputStream.mark(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/* 158 */     this.inputStream.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 163 */     return this.inputStream.skip(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void skipNBytes(long paramLong) {
/* 168 */     if (skipNBytes == null) {
/* 169 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     try {
/* 172 */       skipNBytes.invoke(this.inputStream, new Object[] { Long.valueOf(paramLong) }); return;
/* 173 */     } catch (Exception exception) {
/* 174 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long transferTo(OutputStream paramOutputStream) {
/* 180 */     if (transferTo == null) {
/* 181 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     try {
/* 184 */       return ((Long)transferTo.invoke(this.inputStream, new Object[] { paramOutputStream })).longValue();
/* 185 */     } catch (Exception exception) {
/* 186 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     return this.inputStream.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 197 */     if (this.inputStream != null)
/*     */       try {
/* 199 */         this.inputStream.close(); return;
/*     */       } finally {
/* 201 */         this.inputStream = null;
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgrap\\utils\ProxyingInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */