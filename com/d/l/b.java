/*      */ package com.d.l;
/*      */ 
/*      */ import com.d.e.aa;
/*      */ import com.d.i.a.r;
/*      */ import com.d.m.l;
/*      */ import java.awt.Polygon;
/*      */ import java.awt.Shape;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Ellipse2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.NamedNodeMap;
/*      */ import org.w3c.dom.Node;
/*      */ import org.w3c.dom.NodeList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class b
/*      */ {
/*      */   private r a;
/*      */   private String b;
/*      */   private int c;
/*      */   private List<String> d;
/*      */   private String e;
/*      */   
/*      */   public static Map<Shape, String> a(Element paramElement, aa paramaa) {
/*      */     String str;
/*   58 */     if ((str = paramElement.getAttribute("usemap")) == null || str.isEmpty()) {
/*   59 */       return null;
/*      */     }
/*      */     
/*   62 */     str = str.substring(1);
/*   63 */     Node node = paramElement.getOwnerDocument().getElementById(str);
/*   64 */     if (node == null) {
/*   65 */       NodeList nodeList = paramElement.getOwnerDocument().getElementsByTagName("map");
/*   66 */       for (byte b1 = 0; b1 < nodeList.getLength(); b1++) {
/*   67 */         String str1 = a(nodeList.item(b1).getAttributes(), "name");
/*   68 */         if (a(str, str1)) {
/*   69 */           node = nodeList.item(b1);
/*      */           break;
/*      */         } 
/*      */       } 
/*   73 */       if (node == null) {
/*   74 */         l.g(Level.INFO, "No map named: '" + str + "'");
/*   75 */         return null;
/*      */       } 
/*      */     } 
/*   78 */     return a(node, paramaa);
/*      */   }
/*      */   
/*      */   private static boolean a(String paramString1, String paramString2) {
/*   82 */     return ((paramString1 == null && paramString2 == null) || (paramString1 != null && paramString1.equals(paramString2)));
/*      */   }
/*      */   
/*      */   private static boolean b(String paramString1, String paramString2) {
/*   86 */     return paramString1.equalsIgnoreCase(paramString2);
/*      */   }
/*      */   
/*      */   private static Map<Shape, String> a(Node paramNode, aa paramaa) {
/*   90 */     if (paramNode == null)
/*   91 */       return Collections.emptyMap(); 
/*   92 */     if (paramNode.hasChildNodes()) {
/*   93 */       AffineTransform affineTransform = AffineTransform.getScaleInstance(paramaa.s(), paramaa.s());
/*   94 */       NodeList nodeList = paramNode.getChildNodes();
/*   95 */       HashMap<Object, Object> hashMap = new HashMap<>(nodeList.getLength());
/*   96 */       for (byte b1 = 0; b1 < nodeList.getLength(); b1++) {
/*   97 */         Node node = nodeList.item(b1);
/*      */         
/*      */         NamedNodeMap namedNodeMap;
/*      */         
/*  101 */         String str1 = a(namedNodeMap = node.getAttributes(), "shape");
/*      */         String str2;
/*  103 */         if (b("area", node.getNodeName()) && node.hasAttributes() && (str2 = a(namedNodeMap, "coords")) != null) {
/*      */           Shape shape;
/*  105 */           String[] arrayOfString = str2.split(",");
/*  106 */           String str = a(namedNodeMap, "href");
/*  107 */           if (b("rect", str1) || 
/*  108 */             b("rectangle", str1)) {
/*  109 */             shape = a(arrayOfString, 4);
/*  110 */             if (shape != null) {
/*  111 */               hashMap.put(affineTransform.createTransformedShape(shape), str);
/*      */             }
/*  113 */           } else if (b("circ", (String)shape) || 
/*  114 */             b("circle", (String)shape)) {
/*  115 */             shape = a(arrayOfString, 3);
/*  116 */             if (shape != null) {
/*  117 */               hashMap.put(affineTransform.createTransformedShape(shape), str);
/*      */             }
/*  119 */           } else if (b("poly", (String)shape) || 
/*  120 */             b("polygon", (String)shape)) {
/*  121 */             shape = a(arrayOfString, -1);
/*  122 */             if (shape != null) {
/*  123 */               hashMap.put(affineTransform.createTransformedShape(shape), str);
/*      */             }
/*      */           }
/*  126 */           else if (l.b()) {
/*  127 */             l.g(Level.INFO, "Unsupported shape: '" + shape + "'");
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  133 */       return (Map)hashMap;
/*      */     } 
/*  135 */     return Collections.emptyMap();
/*      */   }
/*      */ 
/*      */   
/*      */   private static String a(NamedNodeMap paramNamedNodeMap, String paramString) {
/*  140 */     Node node = paramNamedNodeMap.getNamedItem(paramString);
/*  141 */     return (node == null) ? null : node.getNodeValue();
/*      */   }
/*      */   
/*      */   private static Shape a(String[] paramArrayOfString, int paramInt) {
/*  145 */     if ((-1 == paramInt && 0 == paramArrayOfString.length % 2) || paramInt == paramArrayOfString.length) {
/*  146 */       byte b1; float[] arrayOfFloat = new float[paramArrayOfString.length];
/*  147 */       byte b2 = 0; int i; byte b3;
/*  148 */       for (i = (paramArrayOfString = paramArrayOfString).length, b3 = 0; b3 < i; ) { String str = paramArrayOfString[b3];
/*      */         try {
/*  150 */           arrayOfFloat[b2++] = Float.parseFloat(str.trim());
/*  151 */         } catch (NumberFormatException numberFormatException) {
/*  152 */           l.f(Level.WARNING, "Error while parsing shape coords", numberFormatException);
/*  153 */           return null;
/*      */         }  b3++; }
/*      */       
/*  156 */       if (4 == numberFormatException)
/*  157 */         return new Rectangle2D.Float(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2] - arrayOfFloat[0], arrayOfFloat[3] - arrayOfFloat[1]); 
/*  158 */       if (3 == numberFormatException) {
/*  159 */         float f = arrayOfFloat[2];
/*  160 */         return new Ellipse2D.Float(arrayOfFloat[0] - f, arrayOfFloat[1] - f, f * 2.0F, f * 2.0F);
/*  161 */       }  if (-1 == numberFormatException) {
/*      */         
/*  163 */         int j, arrayOfInt1[] = new int[j = arrayOfFloat.length / 2];
/*  164 */         int[] arrayOfInt2 = new int[j];
/*  165 */         for (byte b4 = 0; b1 < j; b1++) {
/*  166 */           arrayOfInt1[b1] = (int)arrayOfFloat[b4++];
/*  167 */           arrayOfInt2[b1] = (int)arrayOfFloat[b4++];
/*      */         } 
/*  169 */         return new Polygon(arrayOfInt1, arrayOfInt2, j);
/*      */       } 
/*  171 */       l.g(Level.INFO, "Unsupported shape: '" + b1 + "'");
/*  172 */       return null;
/*      */     } 
/*      */     
/*  175 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b() {
/* 1041 */     this.a = null;
/*      */ 
/*      */     
/* 1044 */     this.c = 0;
/*      */     
/* 1046 */     this.d = new ArrayList<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(String paramString) {
/* 1064 */     if (paramString.toLowerCase(Locale.US).equals("all") || this.d
/* 1065 */       .contains("all") || this.d.contains(paramString.toLowerCase(Locale.US))) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(String paramString) {
/* 1074 */     this.b = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(String paramString) {
/* 1083 */     String[] arrayOfString = paramString.split(",");
/* 1084 */     this.d.clear();
/*      */     
/* 1086 */     for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/* 1087 */       this.d.add(arrayOfString[b1].trim().toLowerCase(Locale.US));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void d(String paramString) {
/* 1096 */     this.d.add(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(int paramInt) {
/* 1105 */     this.c = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(r paramr) {
/* 1132 */     this.a = paramr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String a() {
/* 1141 */     return this.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> b() {
/* 1150 */     return this.d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int c() {
/* 1159 */     return this.c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public r d() {
/* 1186 */     return this.a;
/*      */   }
/*      */   
/*      */   public String e() {
/* 1190 */     return this.e;
/*      */   }
/*      */   
/*      */   public void e(String paramString) {
/* 1194 */     this.e = paramString;
/*      */   }
/*      */   
/*      */   public boolean f() {
/* 1198 */     return (this.e != null);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */