/*     */ package net.bytebuddy.jar.asm;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constants
/*     */ {
/*     */   static void a(Object<?> paramObject) {
/*     */     String str;
/* 188 */     if (!a(str = (paramObject = (Object<?>)paramObject.getClass()).getName().replace('.', '/'))) {
/* 189 */       a(paramObject.getClassLoader().getResourceAsStream(str + ".class"));
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean a(String paramString) {
/* 194 */     if (!paramString.startsWith("net/bytebuddy/jar/asm/")) {
/* 195 */       return false;
/*     */     }
/* 197 */     String str = "(Annotation|Class|Field|Method|Module|RecordComponent|Signature)";
/* 198 */     if (paramString.contains("Test$") || 
/* 199 */       Pattern.matches("net/bytebuddy/jar/asm/util/Trace" + str + "Visitor(\\$.*)?", paramString) || 
/*     */       
/* 201 */       Pattern.matches("net/bytebuddy/jar/asm/util/Check" + str + "Adapter(\\$.*)?", paramString)) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private static void a(InputStream paramInputStream) {
/* 206 */     if (paramInputStream == null) {
/* 207 */       throw new IllegalStateException("Bytecode not available, can't check class version");
/*     */     }
/*     */     
/* 210 */     try { DataInputStream dataInputStream = new DataInputStream(paramInputStream); 
/* 211 */       try { dataInputStream.readInt();
/* 212 */         int i = dataInputStream.readUnsignedShort();
/* 213 */         dataInputStream.close(); } catch (Throwable throwable) { try { dataInputStream.close(); } catch (Throwable throwable1) {} throw throwable; }  } catch (IOException iOException)
/* 214 */     { throw new IllegalStateException("I/O error, can't check class version", iOException); }
/*     */     
/* 216 */     if (throwable != '￿')
/* 217 */       throw new IllegalStateException("ASM9_EXPERIMENTAL can only be used by classes compiled with --enable-preview"); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Constants.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */