/*     */ package com.badlogic.gdx.utils.compression;
/*     */ 
/*     */ import com.badlogic.gdx.utils.compression.lzma.Decoder;
/*     */ import com.badlogic.gdx.utils.compression.lzma.Encoder;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Lzma
/*     */ {
/*     */   static class CommandLine
/*     */   {
/*     */     public static final int kEncode = 0;
/*     */     public static final int kDecode = 1;
/*     */     public static final int kBenchmak = 2;
/*  34 */     public int Command = -1;
/*  35 */     public int NumBenchmarkPasses = 10;
/*     */     
/*  37 */     public int DictionarySize = 8388608;
/*     */     
/*     */     public boolean DictionarySizeIsDefined = false;
/*  40 */     public int Lc = 3;
/*  41 */     public int Lp = 0;
/*  42 */     public int Pb = 2;
/*     */     
/*  44 */     public int Fb = 128;
/*     */     
/*     */     public boolean FbIsDefined = false;
/*     */     
/*     */     public boolean Eos = false;
/*  49 */     public int Algorithm = 2;
/*  50 */     public int MatchFinder = 1;
/*     */ 
/*     */     
/*     */     public String InFile;
/*     */ 
/*     */     
/*     */     public String OutFile;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void compress(InputStream paramInputStream, OutputStream paramOutputStream) {
/*     */     long l;
/*  62 */     CommandLine commandLine = new CommandLine();
/*  63 */     boolean bool = false;
/*  64 */     if (commandLine.Eos) bool = true; 
/*     */     Encoder encoder;
/*  66 */     if (!(encoder = new Encoder()).SetAlgorithm(commandLine.Algorithm)) throw new RuntimeException("Incorrect compression mode"); 
/*  67 */     if (!encoder.SetDictionarySize(commandLine.DictionarySize)) throw new RuntimeException("Incorrect dictionary size"); 
/*  68 */     if (!encoder.SetNumFastBytes(commandLine.Fb)) throw new RuntimeException("Incorrect -fb value"); 
/*  69 */     if (!encoder.SetMatchFinder(commandLine.MatchFinder)) throw new RuntimeException("Incorrect -mf value"); 
/*  70 */     if (!encoder.SetLcLpPb(commandLine.Lc, commandLine.Lp, commandLine.Pb)) throw new RuntimeException("Incorrect -lc or -lp or -pb value"); 
/*  71 */     encoder.SetEndMarkerMode(bool);
/*  72 */     encoder.WriteCoderProperties(paramOutputStream);
/*     */     
/*  74 */     if (bool) {
/*  75 */       l = -1L;
/*     */     }
/*  77 */     else if ((l = paramInputStream.available()) == 0L) {
/*  78 */       l = -1L;
/*     */     } 
/*     */     
/*  81 */     for (byte b = 0; b < 8; b++) {
/*  82 */       paramOutputStream.write((int)(l >>> b * 8) & 0xFF);
/*     */     }
/*  84 */     encoder.Code(paramInputStream, paramOutputStream, -1L, -1L, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void decompress(InputStream paramInputStream, OutputStream paramOutputStream) {
/*  94 */     byte[] arrayOfByte = new byte[5];
/*  95 */     if (paramInputStream.read(arrayOfByte, 0, 5) != 5) throw new RuntimeException("input .lzma file is too short"); 
/*     */     Decoder decoder;
/*  97 */     if (!(decoder = new Decoder()).SetDecoderProperties(arrayOfByte)) throw new RuntimeException("Incorrect stream properties"); 
/*  98 */     long l = 0L;
/*  99 */     for (byte b = 0; b < 8; b++) {
/*     */       int i;
/* 101 */       if ((i = paramInputStream.read()) < 0) {
/* 102 */         throw new RuntimeException("Can't read stream size");
/*     */       }
/* 104 */       l |= i << b * 8;
/*     */     } 
/* 106 */     if (!decoder.Code(paramInputStream, paramOutputStream, l))
/* 107 */       throw new RuntimeException("Error in data stream"); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\compression\Lzma.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */