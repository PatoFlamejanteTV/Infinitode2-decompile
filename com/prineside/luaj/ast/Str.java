/*    */ package com.prineside.luaj.ast;
/*    */ 
/*    */ import com.prineside.luaj.LuaString;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Str
/*    */ {
/*    */   public static LuaString quoteString(String paramString) {
/*    */     byte[] arrayOfByte;
/* 36 */     return LuaString.valueUsing(arrayOfByte = unquote(paramString = paramString.substring(1, paramString.length() - 1)));
/*    */   }
/*    */ 
/*    */   
/*    */   public static LuaString charString(String paramString) {
/*    */     byte[] arrayOfByte;
/* 42 */     return LuaString.valueUsing(arrayOfByte = unquote(paramString = paramString.substring(1, paramString.length() - 1)));
/*    */   }
/*    */   
/*    */   public static LuaString longString(String paramString) {
/* 46 */     int i = paramString.indexOf('[', paramString.indexOf('[') + 1) + 1;
/*    */     
/*    */     byte[] arrayOfByte;
/* 49 */     return LuaString.valueUsing(arrayOfByte = iso88591bytes(paramString = paramString.substring(i, paramString.length() - i)));
/*    */   }
/*    */   
/*    */   public static byte[] iso88591bytes(String paramString) {
/*    */     try {
/* 54 */       return paramString.getBytes("ISO8859-1");
/* 55 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 56 */       throw new IllegalStateException("ISO8859-1 not supported");
/*    */     } 
/*    */   }
/*    */   
/*    */   public static byte[] unquote(String paramString) {
/* 61 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*    */     char[] arrayOfChar;
/* 63 */     int i = (arrayOfChar = paramString.toCharArray()).length;
/* 64 */     for (byte b = 0; b < i; b++) {
/* 65 */       if (arrayOfChar[b] == '\\' && b < i) {
/* 66 */         int j; byte b1; switch (arrayOfChar[++b]) { case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7':
/*    */           case '8':
/*    */           case '9':
/* 69 */             j = arrayOfChar[b++] - 48;
/* 70 */             for (b1 = 0; b < i && b1 < 2 && arrayOfChar[b] >= '0' && arrayOfChar[b] <= '9'; b++, b1++)
/* 71 */               j = j * 10 + arrayOfChar[b] - 48; 
/* 72 */             byteArrayOutputStream.write((byte)j);
/* 73 */             b--; break;
/*    */           case 'a':
/* 75 */             byteArrayOutputStream.write(7); break;
/* 76 */           case 'b': byteArrayOutputStream.write(8); break;
/* 77 */           case 'f': byteArrayOutputStream.write(12); break;
/* 78 */           case 'n': byteArrayOutputStream.write(10); break;
/* 79 */           case 'r': byteArrayOutputStream.write(13); break;
/* 80 */           case 't': byteArrayOutputStream.write(9); break;
/* 81 */           case 'v': byteArrayOutputStream.write(11); break;
/* 82 */           case '"': byteArrayOutputStream.write(34); break;
/* 83 */           case '\'': byteArrayOutputStream.write(39); break;
/* 84 */           case '\\': byteArrayOutputStream.write(92); break;
/* 85 */           default: byteArrayOutputStream.write((byte)arrayOfChar[b]); break; }
/*    */       
/*    */       } else {
/* 88 */         byteArrayOutputStream.write((byte)arrayOfChar[b]);
/*    */       } 
/*    */     } 
/* 91 */     return byteArrayOutputStream.toByteArray();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\ast\Str.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */