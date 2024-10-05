/*     */ package com.a.a.c.e;
/*     */ 
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.w;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.k.b.l;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.y;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   implements Serializable
/*     */ {
/*     */   private static final Class<?> b;
/*     */   private static final Class<?> c;
/*     */   private static final a d;
/*     */   
/*     */   static {
/*     */     a a1;
/*  53 */     Class<Document> clazz = null; Class<Node> clazz1 = null;
/*     */     try {
/*  55 */       clazz1 = Node.class;
/*  56 */       clazz = Document.class;
/*  57 */     } catch (Throwable throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     b = clazz1;
/*  64 */     c = clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     clazz = null;
/*     */     try {
/*  75 */       a1 = a.a();
/*  76 */     } catch (Throwable throwable) {}
/*  77 */     d = a1;
/*     */   }
/*     */   
/*  80 */   public static final g a = new g();
/*     */ 
/*     */ 
/*     */   
/*     */   private final Map<String, String> e;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Map<String, Object> f;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected g() {
/*  94 */     this.e = new HashMap<>();
/*  95 */     this.e.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
/*     */     
/*  97 */     this.e.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.f = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.f.put("java.sql.Timestamp", l.a);
/* 108 */     this.f.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
/* 109 */     this.f.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.f.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
/* 116 */     this.f.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
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
/*     */   public final o<?> a(y paramy, j paramj, b paramb) {
/*     */     String str1;
/*     */     Class<?> clazz;
/* 130 */     if (a(clazz = paramj.b(), b)) {
/* 131 */       return (o)a("com.fasterxml.jackson.databind.ext.DOMSerializer", paramj);
/*     */     }
/*     */     o<?> o;
/* 134 */     if (d != null && (
/*     */       
/* 136 */       o = d.b(clazz)) != null) {
/* 137 */       return o;
/*     */     }
/*     */ 
/*     */     
/* 141 */     String str2 = clazz.getName();
/*     */     
/*     */     Object object2;
/* 144 */     if ((object2 = this.f.get(str2)) != null) {
/* 145 */       if (object2 instanceof o) {
/* 146 */         return (o)object2;
/*     */       }
/*     */       
/* 149 */       return (o)a((String)object2, paramj);
/*     */     } 
/*     */ 
/*     */     
/* 153 */     if (str2.startsWith("javax.xml.") || a(clazz, "javax.xml.")) {
/* 154 */       str1 = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
/*     */     } else {
/* 156 */       return null;
/*     */     } 
/*     */     
/*     */     Object object1;
/* 160 */     if ((object1 = a(str1, paramj)) == null) {
/* 161 */       return null;
/*     */     }
/* 163 */     return ((w.a)object1).m();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final k<?> a(j paramj, f paramf, b paramb) {
/*     */     String str1;
/* 170 */     Class<?> clazz = paramj.b();
/*     */     k<?> k;
/* 172 */     if (d != null && (
/*     */       
/* 174 */       k = d.a(clazz)) != null) {
/* 175 */       return k;
/*     */     }
/*     */     
/* 178 */     if (a(clazz, b)) {
/* 179 */       return (k)a("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer", paramj);
/*     */     }
/* 181 */     if (a(clazz, c)) {
/* 182 */       return (k)a("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer", paramj);
/*     */     }
/* 184 */     String str2 = clazz.getName();
/*     */     String str3;
/* 186 */     if ((str3 = this.e.get(str2)) != null) {
/* 187 */       return (k)a(str3, paramj);
/*     */     }
/*     */     
/* 190 */     if (str2.startsWith("javax.xml.") || 
/* 191 */       a(clazz, "javax.xml.")) {
/* 192 */       str1 = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
/*     */     } else {
/* 194 */       return null;
/*     */     } 
/*     */     Object object;
/* 197 */     if ((object = a(str1, paramj)) == null) {
/* 198 */       return null;
/*     */     }
/* 200 */     return ((w.a)object).e();
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
/*     */   private static boolean a(Class<?> paramClass1, Class<?> paramClass2) {
/* 221 */     return (paramClass2 != null && paramClass2.isAssignableFrom(paramClass1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(String paramString, j paramj) {
/*     */     try {
/* 233 */       return a(Class.forName(paramString), paramj);
/* 234 */     } catch (Throwable throwable) {
/* 235 */       throw new IllegalStateException("Failed to find class `" + paramString + "` for handling values of type " + 
/* 236 */           i.b(paramj) + ", problem: (" + throwable
/* 237 */           .getClass().getName() + ") " + throwable.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object a(Class<?> paramClass, j paramj) {
/*     */     try {
/* 244 */       return i.b(paramClass, false);
/* 245 */     } catch (Throwable throwable) {
/* 246 */       throw new IllegalStateException("Failed to create instance of `" + paramClass
/* 247 */           .getName() + "` for handling values of type " + i.b(paramj) + ", problem: (" + throwable
/* 248 */           .getClass().getName() + ") " + throwable.getMessage());
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
/*     */   private static boolean a(Class<?> paramClass, String paramString) {
/* 262 */     for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass()) {
/* 263 */       if (paramClass == Object.class) {
/* 264 */         return false;
/*     */       }
/* 266 */       if (paramClass.getName().startsWith(paramString)) {
/* 267 */         return true;
/*     */       }
/*     */     } 
/* 270 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\e\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */