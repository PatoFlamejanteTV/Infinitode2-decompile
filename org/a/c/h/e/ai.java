/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.a.c.i.a;
/*     */ import org.a.c.i.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ai
/*     */ {
/*  38 */   private final Map<Integer, String> a = new TreeMap<Integer, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ai() {
/*  51 */     this.b = 0;
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
/*     */   public final void a(int paramInt, String paramString) {
/*  72 */     if (paramInt < 0 || paramInt > 65535)
/*     */     {
/*  74 */       throw new IllegalArgumentException("CID is not valid");
/*     */     }
/*     */     
/*  77 */     if (paramString.isEmpty())
/*     */     {
/*  79 */       throw new IllegalArgumentException("Text is null or empty");
/*     */     }
/*     */     
/*  82 */     this.a.put(Integer.valueOf(paramInt), paramString);
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
/*     */   public final void a(OutputStream paramOutputStream) {
/*     */     BufferedWriter bufferedWriter;
/*  95 */     a(bufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream, a.a)), "/CIDInit /ProcSet findresource begin");
/*  96 */     a(bufferedWriter, "12 dict begin\n");
/*     */     
/*  98 */     a(bufferedWriter, "begincmap");
/*  99 */     a(bufferedWriter, "/CIDSystemInfo");
/* 100 */     a(bufferedWriter, "<< /Registry (Adobe)");
/* 101 */     a(bufferedWriter, "/Ordering (UCS)");
/* 102 */     a(bufferedWriter, "/Supplement 0");
/* 103 */     a(bufferedWriter, ">> def\n");
/*     */     
/* 105 */     a(bufferedWriter, "/CMapName /Adobe-Identity-UCS def");
/* 106 */     a(bufferedWriter, "/CMapType 2 def\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     a(bufferedWriter, "1 begincodespacerange");
/* 115 */     a(bufferedWriter, "<0000> <FFFF>");
/* 116 */     a(bufferedWriter, "endcodespacerange\n");
/*     */ 
/*     */     
/* 119 */     ArrayList<Integer> arrayList1 = new ArrayList();
/* 120 */     ArrayList<Integer> arrayList2 = new ArrayList();
/* 121 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 123 */     int i = -1;
/* 124 */     String str = null;
/*     */     
/* 126 */     int j = -1;
/*     */     
/* 128 */     for (Iterator<Map.Entry> iterator = this.a.entrySet().iterator(); iterator.hasNext(); ) {
/*     */       Map.Entry<Integer, ?> entry;
/* 130 */       int m = ((Integer)(entry = iterator.next()).getKey()).intValue();
/* 131 */       String str1 = (String)entry.getValue();
/*     */       
/* 133 */       if (m == i + 1 && str
/* 134 */         .codePointCount(0, str.length()) == 1 && str1
/* 135 */         .codePointAt(0) == str.codePointAt(0) + 1 && str
/* 136 */         .codePointAt(0) + 1 <= 255 - m - j) {
/*     */ 
/*     */         
/* 139 */         arrayList2.set(arrayList2.size() - 1, Integer.valueOf(m));
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 144 */         j = m;
/* 145 */         arrayList1.add(Integer.valueOf(m));
/* 146 */         arrayList2.add(Integer.valueOf(m));
/* 147 */         arrayList.add(str1);
/*     */       } 
/* 149 */       i = m;
/* 150 */       str = str1;
/*     */     } 
/*     */ 
/*     */     
/* 154 */     int k = (int)Math.ceil(arrayList1.size() / 100.0D);
/*     */     
/* 156 */     for (byte b = 0; b < k; b++) {
/*     */ 
/*     */       
/* 159 */       byte b1 = (b == k - 1) ? (arrayList1.size() - b * 100) : 100;
/*     */       
/* 161 */       bufferedWriter.write(b1 + " beginbfrange\n");
/* 162 */       for (byte b2 = 0; b2 < b1; b2++) {
/*     */         
/* 164 */         i = b * 100 + b2;
/* 165 */         bufferedWriter.write(60);
/* 166 */         bufferedWriter.write(c.a(((Integer)arrayList1.get(i)).shortValue()));
/* 167 */         bufferedWriter.write("> ");
/*     */         
/* 169 */         bufferedWriter.write(60);
/* 170 */         bufferedWriter.write(c.a(((Integer)arrayList2.get(i)).shortValue()));
/* 171 */         bufferedWriter.write("> ");
/*     */         
/* 173 */         bufferedWriter.write(60);
/* 174 */         bufferedWriter.write(c.a(arrayList.get(i)));
/* 175 */         bufferedWriter.write(">\n");
/*     */       } 
/* 177 */       a(bufferedWriter, "endbfrange\n");
/*     */     } 
/*     */ 
/*     */     
/* 181 */     a(bufferedWriter, "endcmap");
/* 182 */     a(bufferedWriter, "CMapName currentdict /CMap defineresource pop");
/* 183 */     a(bufferedWriter, "end");
/* 184 */     a(bufferedWriter, "end");
/*     */     
/* 186 */     bufferedWriter.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(BufferedWriter paramBufferedWriter, String paramString) {
/* 191 */     paramBufferedWriter.write(paramString);
/* 192 */     paramBufferedWriter.write(10);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */