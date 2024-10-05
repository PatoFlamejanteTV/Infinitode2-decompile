/*      */ package org.a.b.b;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class l
/*      */ {
/*   41 */   private static final org.a.a.a.a a = org.a.a.a.c.a(l.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   47 */   private String[] b = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<i> a(byte[] paramArrayOfbyte, a parama) {
/*   74 */     this.c = parama;
/*   75 */     return a(paramArrayOfbyte);
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
/*      */   private List<i> a(byte[] paramArrayOfbyte) {
/*      */     d d;
/*   89 */     String str = a(d = new d(paramArrayOfbyte));
/*      */     
/*   91 */     if ("OTTO".equals(str)) {
/*      */       
/*   93 */       d = a(d, paramArrayOfbyte);
/*      */     } else {
/*   95 */       if ("ttcf".equals(str))
/*      */       {
/*   97 */         throw new IOException("True Type Collection fonts are not supported.");
/*      */       }
/*   99 */       if ("\000\001\000\000".equals(str))
/*      */       {
/*  101 */         throw new IOException("OpenType fonts containing a true type font are not supported.");
/*      */       }
/*      */ 
/*      */       
/*  105 */       d.a(0);
/*      */     } 
/*      */ 
/*      */     
/*  109 */     c(d);
/*      */     String[] arrayOfString;
/*  111 */     if ((arrayOfString = f(d)) == null)
/*      */     {
/*  113 */       throw new IOException("Name index missing in CFF font");
/*      */     }
/*  115 */     byte[][] arrayOfByte1 = e(d);
/*  116 */     this.b = f(d);
/*  117 */     byte[][] arrayOfByte2 = e(d);
/*      */     
/*  119 */     ArrayList<i> arrayList = new ArrayList();
/*  120 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*      */       i i;
/*      */       
/*  123 */       (i = a(d, arrayOfString[b], arrayOfByte1[b])).a(arrayOfByte2);
/*      */       
/*  125 */       arrayList.add(i);
/*      */     } 
/*  127 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static d a(d paramd, byte[] paramArrayOfbyte) {
/*  134 */     short s = paramd.e();
/*      */     
/*  136 */     paramd.e();
/*      */     
/*  138 */     paramd.e();
/*      */     
/*  140 */     paramd.e();
/*  141 */     for (byte b = 0; b < s; b++) {
/*      */       
/*  143 */       String str = a(paramd);
/*      */       
/*  145 */       b(paramd);
/*  146 */       long l1 = b(paramd);
/*  147 */       long l2 = b(paramd);
/*  148 */       if ("CFF ".equals(str)) {
/*      */         
/*  150 */         byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfbyte, (int)l1, (int)(l1 + l2));
/*  151 */         return new d(arrayOfByte);
/*      */       } 
/*      */     } 
/*  154 */     throw new IOException("CFF tag not found in this OpenType font.");
/*      */   }
/*      */ 
/*      */   
/*      */   private static String a(d paramd) {
/*  159 */     byte[] arrayOfByte = paramd.c(4);
/*  160 */     return new String(arrayOfByte, org.a.b.h.b.a);
/*      */   }
/*      */ 
/*      */   
/*      */   private static long b(d paramd) {
/*  165 */     return (paramd.j() << 16 | paramd.j());
/*      */   }
/*      */ 
/*      */   
/*      */   private static m c(d paramd) {
/*      */     m m;
/*  171 */     m.a(m = new m((byte)0), paramd.i());
/*  172 */     m.b(m, paramd.i());
/*  173 */     m.c(m, paramd.i());
/*  174 */     m.d(m, paramd.k());
/*  175 */     return m;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int[] d(d paramd) {
/*      */     int i;
/*  181 */     if ((i = paramd.j()) == 0)
/*      */     {
/*  183 */       return null;
/*      */     }
/*  185 */     int j = paramd.k();
/*  186 */     int[] arrayOfInt = new int[i + 1];
/*  187 */     for (byte b = 0; b <= i; b++) {
/*      */       int k;
/*      */       
/*  190 */       if ((k = paramd.d(j)) > paramd.h())
/*      */       {
/*  192 */         throw new IOException("illegal offset value " + k + " in CFF font");
/*      */       }
/*  194 */       arrayOfInt[b] = k;
/*      */     } 
/*  196 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[][] e(d paramd) {
/*      */     int[] arrayOfInt;
/*  202 */     if ((arrayOfInt = d(paramd)) == null)
/*      */     {
/*  204 */       return (byte[][])null;
/*      */     }
/*      */     int i;
/*  207 */     byte[][] arrayOfByte = new byte[i = arrayOfInt.length - 1][];
/*  208 */     for (byte b = 0; b < i; b++) {
/*      */       
/*  210 */       int j = arrayOfInt[b + 1] - arrayOfInt[b];
/*  211 */       arrayOfByte[b] = paramd.c(j);
/*      */     } 
/*  213 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String[] f(d paramd) {
/*      */     int[] arrayOfInt;
/*  219 */     if ((arrayOfInt = d(paramd)) == null)
/*      */     {
/*  221 */       return null;
/*      */     }
/*      */     int i;
/*  224 */     String[] arrayOfString = new String[i = arrayOfInt.length - 1];
/*  225 */     for (byte b = 0; b < i; b++) {
/*      */       int j;
/*      */       
/*  228 */       if ((j = arrayOfInt[b + 1] - arrayOfInt[b]) < 0)
/*      */       {
/*  230 */         throw new IOException("Negative index data length + " + j + " at " + b + ": offsets[" + (b + 1) + "]=" + arrayOfInt[b + 1] + ", offsets[" + b + "]=" + arrayOfInt[b]);
/*      */       }
/*      */ 
/*      */       
/*  234 */       arrayOfString[b] = new String(paramd.c(j), org.a.b.h.b.a);
/*      */     } 
/*  236 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */   
/*      */   private static c g(d paramd) {
/*  241 */     c c = new c((byte)0);
/*  242 */     while (paramd.a())
/*      */     {
/*  244 */       c.a(h(paramd));
/*      */     }
/*  246 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   private static c a(d paramd, int paramInt) {
/*  251 */     c c = new c((byte)0);
/*  252 */     paramInt = paramd.b() + paramInt;
/*  253 */     while (paramd.b() < paramInt)
/*      */     {
/*  255 */       c.a(h(paramd));
/*      */     }
/*  257 */     return c;
/*      */   }
/*      */ 
/*      */   
/*      */   private static c.a h(d paramd) {
/*  262 */     c.a a1 = new c.a((byte)0);
/*      */     
/*      */     while (true) {
/*      */       int i;
/*      */       
/*  267 */       if ((i = paramd.d()) >= 0 && i <= 21) {
/*      */         
/*  269 */         c.a.a(a1, b(paramd, i));
/*      */         break;
/*      */       } 
/*  272 */       if (i == 28 || i == 29) {
/*      */         
/*  274 */         c.a.a(a1).add(d(paramd, i)); continue;
/*      */       } 
/*  276 */       if (i == 30) {
/*      */         
/*  278 */         c.a.a(a1).add(i(paramd)); continue;
/*      */       } 
/*  280 */       if (i >= 32 && i <= 254) {
/*      */         
/*  282 */         c.a.a(a1).add(d(paramd, i));
/*      */         
/*      */         continue;
/*      */       } 
/*  286 */       throw new IOException("invalid DICT data b0 byte: " + i);
/*      */     } 
/*      */     
/*  289 */     return a1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static k b(d paramd, int paramInt) {
/*      */     k.a a1;
/*  295 */     return k.a(a1 = c(paramd, paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   private static k.a c(d paramd, int paramInt) {
/*  300 */     if (paramInt == 12) {
/*      */       
/*  302 */       int i = paramd.d();
/*  303 */       return new k.a(paramInt, i);
/*      */     } 
/*  305 */     return new k.a(paramInt);
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
/*      */   private static Integer d(d paramd, int paramInt) {
/*      */     // Byte code:
/*      */     //   0: iload_1
/*      */     //   1: bipush #28
/*      */     //   3: if_icmpne -> 14
/*      */     //   6: aload_0
/*      */     //   7: invokevirtual e : ()S
/*      */     //   10: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   13: areturn
/*      */     //   14: iload_1
/*      */     //   15: bipush #29
/*      */     //   17: if_icmpne -> 28
/*      */     //   20: aload_0
/*      */     //   21: invokevirtual g : ()I
/*      */     //   24: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   27: areturn
/*      */     //   28: iload_1
/*      */     //   29: bipush #32
/*      */     //   31: if_icmplt -> 50
/*      */     //   34: iload_1
/*      */     //   35: sipush #246
/*      */     //   38: if_icmpgt -> 50
/*      */     //   41: iload_1
/*      */     //   42: sipush #139
/*      */     //   45: isub
/*      */     //   46: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   49: areturn
/*      */     //   50: iload_1
/*      */     //   51: sipush #247
/*      */     //   54: if_icmplt -> 86
/*      */     //   57: iload_1
/*      */     //   58: sipush #250
/*      */     //   61: if_icmpgt -> 86
/*      */     //   64: aload_0
/*      */     //   65: invokevirtual d : ()I
/*      */     //   68: istore_0
/*      */     //   69: iload_1
/*      */     //   70: sipush #247
/*      */     //   73: isub
/*      */     //   74: bipush #8
/*      */     //   76: ishl
/*      */     //   77: iload_0
/*      */     //   78: iadd
/*      */     //   79: bipush #108
/*      */     //   81: iadd
/*      */     //   82: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   85: areturn
/*      */     //   86: iload_1
/*      */     //   87: sipush #251
/*      */     //   90: if_icmplt -> 123
/*      */     //   93: iload_1
/*      */     //   94: sipush #254
/*      */     //   97: if_icmpgt -> 123
/*      */     //   100: aload_0
/*      */     //   101: invokevirtual d : ()I
/*      */     //   104: istore_0
/*      */     //   105: iload_1
/*      */     //   106: sipush #251
/*      */     //   109: isub
/*      */     //   110: ineg
/*      */     //   111: bipush #8
/*      */     //   113: ishl
/*      */     //   114: iload_0
/*      */     //   115: isub
/*      */     //   116: bipush #108
/*      */     //   118: isub
/*      */     //   119: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   122: areturn
/*      */     //   123: new java/lang/IllegalArgumentException
/*      */     //   126: dup
/*      */     //   127: invokespecial <init> : ()V
/*      */     //   130: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #310	-> 0
/*      */     //   #312	-> 6
/*      */     //   #314	-> 14
/*      */     //   #316	-> 20
/*      */     //   #318	-> 28
/*      */     //   #320	-> 41
/*      */     //   #322	-> 50
/*      */     //   #324	-> 64
/*      */     //   #325	-> 69
/*      */     //   #327	-> 86
/*      */     //   #329	-> 100
/*      */     //   #330	-> 105
/*      */     //   #334	-> 123
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
/*      */   private static Double i(d paramd) {
/*  343 */     StringBuilder stringBuilder = new StringBuilder();
/*  344 */     boolean bool1 = false;
/*  345 */     boolean bool2 = false;
/*  346 */     boolean bool3 = false;
/*  347 */     while (!bool1) {
/*      */       
/*  349 */       int i = paramd.d(); int[] arrayOfInt;
/*      */       byte b;
/*  351 */       for (arrayOfInt = arrayOfInt = new int[] { i / 16, i % 16 }, b = 0; b < 2; b++) {
/*      */         int j;
/*  353 */         switch (j = arrayOfInt[b]) {
/*      */           
/*      */           case 0:
/*      */           case 1:
/*      */           case 2:
/*      */           case 3:
/*      */           case 4:
/*      */           case 5:
/*      */           case 6:
/*      */           case 7:
/*      */           case 8:
/*      */           case 9:
/*  365 */             stringBuilder.append(j);
/*  366 */             bool2 = false;
/*      */             break;
/*      */           case 10:
/*  369 */             stringBuilder.append(".");
/*      */             break;
/*      */           case 11:
/*  372 */             if (bool3) {
/*      */               
/*  374 */               (new StringBuilder("duplicate 'E' ignored after ")).append(stringBuilder);
/*      */               break;
/*      */             } 
/*  377 */             stringBuilder.append("E");
/*  378 */             bool2 = true;
/*  379 */             bool3 = true;
/*      */             break;
/*      */           case 12:
/*  382 */             if (bool3) {
/*      */               
/*  384 */               (new StringBuilder("duplicate 'E-' ignored after ")).append(stringBuilder);
/*      */               break;
/*      */             } 
/*  387 */             stringBuilder.append("E-");
/*  388 */             bool2 = true;
/*  389 */             bool3 = true;
/*      */             break;
/*      */           case 13:
/*      */             break;
/*      */           case 14:
/*  394 */             stringBuilder.append("-");
/*      */             break;
/*      */           case 15:
/*  397 */             bool1 = true;
/*      */             break;
/*      */           default:
/*  400 */             throw new IllegalArgumentException();
/*      */         } 
/*      */       } 
/*      */     } 
/*  404 */     if (bool2)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  409 */       stringBuilder.append("0");
/*      */     }
/*  411 */     if (stringBuilder.length() == 0)
/*      */     {
/*  413 */       return Double.valueOf(0.0D);
/*      */     }
/*  415 */     return Double.valueOf(stringBuilder.toString());
/*      */   }
/*      */   
/*      */   private i a(d paramd, String paramString, byte[] paramArrayOfbyte) {
/*      */     List<Map<String, Object>> list;
/*      */     o o;
/*      */     j j;
/*      */     List<Number> list1;
/*      */     c c;
/*      */     d d1;
/*      */     c.a a1;
/*  426 */     if ((a1 = (c = g(d1 = new d(paramArrayOfbyte))).a("SyntheticBase")) != null)
/*      */     {
/*  428 */       throw new IOException("Synthetic Fonts are not supported");
/*      */     }
/*      */ 
/*      */     
/*      */     boolean bool;
/*      */     
/*  434 */     if (bool = (c.a("ROS") != null) ? true : false) {
/*      */       
/*  436 */       a a3 = new a();
/*  437 */       c.a a4 = c.a("ROS");
/*  438 */       a3.c(a(a4.a(0).intValue()));
/*  439 */       a3.d(a(a4.a(1).intValue()));
/*  440 */       a3.a(a4.a(2).intValue());
/*      */     }
/*      */     else {
/*      */       
/*  444 */       o = new o();
/*      */     } 
/*      */ 
/*      */     
/*  448 */     this.d = paramString;
/*  449 */     o.e(paramString);
/*      */ 
/*      */     
/*  452 */     o.a("version", a(c, "version"));
/*  453 */     o.a("Notice", a(c, "Notice"));
/*  454 */     o.a("Copyright", a(c, "Copyright"));
/*  455 */     o.a("FullName", a(c, "FullName"));
/*  456 */     o.a("FamilyName", a(c, "FamilyName"));
/*  457 */     o.a("Weight", a(c, "Weight"));
/*  458 */     o.a("isFixedPitch", c.a("isFixedPitch", false));
/*  459 */     o.a("ItalicAngle", c.a("ItalicAngle", Integer.valueOf(0)));
/*  460 */     o.a("UnderlinePosition", c.a("UnderlinePosition", Integer.valueOf(-100)));
/*  461 */     o.a("UnderlineThickness", c.a("UnderlineThickness", Integer.valueOf(50)));
/*  462 */     o.a("PaintType", c.a("PaintType", Integer.valueOf(0)));
/*  463 */     o.a("CharstringType", c.a("CharstringType", Integer.valueOf(2)));
/*  464 */     o.a("FontMatrix", c.a("FontMatrix", Arrays.asList(new Number[] {
/*  465 */               Double.valueOf(0.001D), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.001D), 
/*  466 */               Double.valueOf(0.0D), Double.valueOf(0.0D) })));
/*  467 */     o.a("UniqueID", c.a("UniqueID", (Number)null));
/*  468 */     o.a("FontBBox", c.a("FontBBox", 
/*  469 */           Arrays.asList(new Number[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) })));
/*  470 */     o.a("StrokeWidth", c.a("StrokeWidth", Integer.valueOf(0)));
/*  471 */     o.a("XUID", c.a("XUID", (List<Number>)null));
/*      */     
/*      */     c.a a2;
/*      */     
/*  475 */     int i = (a2 = c.a("CharStrings")).a(0).intValue();
/*  476 */     paramd.a(i);
/*  477 */     byte[][] arrayOfByte = e(paramd);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  482 */     if ((a2 = c.a("charset")) != null) {
/*      */       
/*  484 */       int k = a2.a(0).intValue();
/*  485 */       if (!bool && k == 0) {
/*      */         
/*  487 */         j = j.b();
/*      */       } else {
/*  489 */         f f; if (!bool && j == true) {
/*      */           
/*  491 */           f = f.b();
/*      */         } else {
/*  493 */           h h; if (!bool && f == 2)
/*      */           {
/*  495 */             h = h.b();
/*      */           }
/*      */           else
/*      */           {
/*  499 */             paramd.a(h);
/*  500 */             c c1 = a(paramd, arrayOfByte.length, bool);
/*      */           }
/*      */         
/*      */         } 
/*      */       } 
/*  505 */     } else if (bool) {
/*      */ 
/*      */       
/*  508 */       e e = new e(arrayOfByte.length);
/*      */     }
/*      */     else {
/*      */       
/*  512 */       j = j.b();
/*      */     } 
/*      */     
/*  515 */     o.a(j);
/*      */ 
/*      */     
/*  518 */     o.d = arrayOfByte;
/*      */ 
/*      */     
/*  521 */     if (bool) {
/*      */       
/*  523 */       a(paramd, c, (a)o, arrayOfByte.length);
/*      */       
/*  525 */       j = null;
/*      */       
/*  527 */       if (!(list = ((a)o).g()).isEmpty() && ((Map)list.get(0)).containsKey("FontMatrix"))
/*      */       {
/*  529 */         list1 = (List)((Map)list.get(0)).get("FontMatrix");
/*      */       }
/*      */ 
/*      */       
/*  533 */       if ((list = (List)c.a("FontMatrix", (List<Number>)null)) == null) {
/*      */         
/*  535 */         if (list1 != null)
/*      */         {
/*  537 */           o.a("FontMatrix", list1);
/*      */         
/*      */         }
/*      */         else
/*      */         {
/*  542 */           o.a("FontMatrix", c.a("FontMatrix", 
/*  543 */                 Arrays.asList(new Number[] { Double.valueOf(0.001D), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.001D), 
/*  544 */                     Double.valueOf(0.0D), Double.valueOf(0.0D) })));
/*      */         }
/*      */       
/*  547 */       } else if (list1 != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  552 */         a((List)list, list1);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  558 */       a((d)list, c, o, (c)list1);
/*      */     } 
/*      */     
/*  561 */     return o;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(List<Number> paramList1, List<Number> paramList2) {
/*  570 */     double d1 = ((Number)paramList1.get(0)).doubleValue();
/*  571 */     double d2 = ((Number)paramList1.get(1)).doubleValue();
/*  572 */     double d3 = ((Number)paramList1.get(2)).doubleValue();
/*  573 */     double d4 = ((Number)paramList1.get(3)).doubleValue();
/*  574 */     double d5 = ((Number)paramList1.get(4)).doubleValue();
/*  575 */     double d6 = ((Number)paramList1.get(5)).doubleValue();
/*      */     
/*  577 */     double d7 = ((Number)paramList2.get(0)).doubleValue();
/*  578 */     double d8 = ((Number)paramList2.get(1)).doubleValue();
/*  579 */     double d9 = ((Number)paramList2.get(2)).doubleValue();
/*  580 */     double d10 = ((Number)paramList2.get(3)).doubleValue();
/*  581 */     double d11 = ((Number)paramList2.get(4)).doubleValue();
/*  582 */     double d12 = ((Number)paramList2.get(5)).doubleValue();
/*      */     
/*  584 */     paramList1.set(0, Double.valueOf(d1 * d7 + d2 * d9));
/*  585 */     paramList1.set(1, Double.valueOf(d1 * d8 + d2 * d4));
/*  586 */     paramList1.set(2, Double.valueOf(d3 * d7 + d4 * d9));
/*  587 */     paramList1.set(3, Double.valueOf(d3 * d8 + d4 * d10));
/*  588 */     paramList1.set(4, Double.valueOf(d5 * d7 + d6 * d9 + d11));
/*  589 */     paramList1.set(5, Double.valueOf(d5 * d8 + d6 * d10 + d12));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd, c paramc, a parama, int paramInt) {
/*      */     c.a a2;
/*  601 */     if ((a2 = paramc.a("FDArray")) == null)
/*      */     {
/*  603 */       throw new IOException("FDArray is missing for a CIDKeyed Font.");
/*      */     }
/*      */ 
/*      */     
/*  607 */     int i = a2.a(0).intValue();
/*  608 */     paramd.a(i);
/*  609 */     byte[][] arrayOfByte = e(paramd);
/*      */     
/*  611 */     LinkedList<Map<String, Object>> linkedList = new LinkedList();
/*  612 */     LinkedList<LinkedHashMap<Object, Object>> linkedList1 = new LinkedList(); int j;
/*      */     byte b;
/*  614 */     for (j = (arrayOfByte = arrayOfByte).length, b = 0; b < j; ) { byte[] arrayOfByte1 = arrayOfByte[b];
/*      */       
/*      */       c c1;
/*      */       
/*      */       d d1;
/*      */       
/*      */       c.a a3;
/*  621 */       if ((a3 = (c1 = g(d1 = new d(arrayOfByte1))).a("Private")) == null)
/*      */       {
/*  623 */         throw new IOException("Font DICT invalid without \"Private\" entry");
/*      */       }
/*      */       
/*      */       LinkedHashMap<Object, Object> linkedHashMap;
/*      */       
/*  628 */       (linkedHashMap = new LinkedHashMap<Object, Object>(4)).put("FontName", a(c1, "FontName"));
/*  629 */       linkedHashMap.put("FontType", c1.a("FontType", Integer.valueOf(0)));
/*  630 */       linkedHashMap.put("FontBBox", c1.a("FontBBox", (List<Number>)null));
/*  631 */       linkedHashMap.put("FontMatrix", c1.a("FontMatrix", (List<Number>)null));
/*      */       
/*  633 */       linkedList1.add(linkedHashMap);
/*      */       
/*  635 */       int k = a3.a(1).intValue();
/*  636 */       paramd.a(k);
/*  637 */       int n = a3.a(0).intValue();
/*      */       
/*      */       c c2;
/*      */       
/*  641 */       Map<String, Object> map = a(c2 = a(paramd, n));
/*  642 */       linkedList.add(map);
/*      */       
/*      */       int m;
/*      */       
/*  646 */       if ((m = ((Integer)c2.a("Subrs", Integer.valueOf(0))).intValue()) > 0) {
/*      */         
/*  648 */         paramd.a(k + m);
/*  649 */         map.put("Subrs", e(paramd));
/*      */       } 
/*      */       
/*      */       b++; }
/*      */     
/*      */     c.a a1;
/*  655 */     j = (a1 = paramc.a("FDSelect")).a(0).intValue();
/*  656 */     paramd.a(j);
/*  657 */     s s = a(paramd, paramInt, parama);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  663 */     parama.a((List)linkedList1);
/*  664 */     parama.b(linkedList);
/*  665 */     parama.a(s);
/*      */   }
/*      */ 
/*      */   
/*      */   private static Map<String, Object> a(c paramc) {
/*      */     LinkedHashMap<Object, Object> linkedHashMap;
/*  671 */     (linkedHashMap = new LinkedHashMap<Object, Object>(17)).put("BlueValues", paramc.b("BlueValues", null));
/*  672 */     linkedHashMap.put("OtherBlues", paramc.b("OtherBlues", null));
/*  673 */     linkedHashMap.put("FamilyBlues", paramc.b("FamilyBlues", null));
/*  674 */     linkedHashMap.put("FamilyOtherBlues", paramc.b("FamilyOtherBlues", null));
/*  675 */     linkedHashMap.put("BlueScale", paramc.a("BlueScale", Double.valueOf(0.039625D)));
/*  676 */     linkedHashMap.put("BlueShift", paramc.a("BlueShift", Integer.valueOf(7)));
/*  677 */     linkedHashMap.put("BlueFuzz", paramc.a("BlueFuzz", Integer.valueOf(1)));
/*  678 */     linkedHashMap.put("StdHW", paramc.a("StdHW", (Number)null));
/*  679 */     linkedHashMap.put("StdVW", paramc.a("StdVW", (Number)null));
/*  680 */     linkedHashMap.put("StemSnapH", paramc.b("StemSnapH", null));
/*  681 */     linkedHashMap.put("StemSnapV", paramc.b("StemSnapV", null));
/*  682 */     linkedHashMap.put("ForceBold", paramc.a("ForceBold", false));
/*  683 */     linkedHashMap.put("LanguageGroup", paramc.a("LanguageGroup", Integer.valueOf(0)));
/*  684 */     linkedHashMap.put("ExpansionFactor", paramc.a("ExpansionFactor", Double.valueOf(0.06D)));
/*  685 */     linkedHashMap.put("initialRandomSeed", paramc.a("initialRandomSeed", Integer.valueOf(0)));
/*  686 */     linkedHashMap.put("defaultWidthX", paramc.a("defaultWidthX", Integer.valueOf(0)));
/*  687 */     linkedHashMap.put("nominalWidthX", paramc.a("nominalWidthX", Integer.valueOf(0)));
/*  688 */     return (Map)linkedHashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(d paramd, c paramc, o paramo, c paramc1) {
/*      */     m m;
/*      */     g g;
/*      */     e e;
/*      */     c.a a2;
/*      */     boolean bool;
/*  701 */     switch (bool = ((a2 = paramc.a("Encoding")) != null) ? a2.a(0).intValue() : false) {
/*      */       
/*      */       case false:
/*  704 */         m = m.a();
/*      */         break;
/*      */       case true:
/*  707 */         g = g.a();
/*      */         break;
/*      */       default:
/*  710 */         paramd.a(bool);
/*  711 */         e = a(paramd, (c)g);
/*      */         break;
/*      */     } 
/*  714 */     paramo.a(e);
/*      */     
/*      */     c.a a1;
/*      */     
/*  718 */     if ((a1 = paramc.a("Private")) == null)
/*      */     {
/*  720 */       throw new IOException("Private dictionary entry missing for font " + paramo.a);
/*      */     }
/*  722 */     int j = a1.a(1).intValue();
/*  723 */     paramd.a(j);
/*  724 */     int i = a1.a(0).intValue();
/*      */     
/*      */     c c1;
/*      */     
/*      */     Map<String, Object> map;
/*  729 */     for (Map.Entry<String, Object> entry : (map = a(c1 = a(paramd, i))).entrySet())
/*      */     {
/*  731 */       paramo.b((String)entry.getKey(), entry.getValue());
/*      */     }
/*      */     
/*      */     int k;
/*      */     
/*  736 */     if ((k = ((Integer)c1.a("Subrs", Integer.valueOf(0))).intValue()) > 0) {
/*      */       
/*  738 */       paramd.a(j + k);
/*  739 */       paramo.b("Subrs", e(paramd));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private String a(int paramInt) {
/*  745 */     if (paramInt >= 0 && paramInt <= 390)
/*      */     {
/*  747 */       return n.a(paramInt);
/*      */     }
/*  749 */     if (paramInt - 391 < this.b.length)
/*      */     {
/*  751 */       return this.b[paramInt - 391];
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  756 */     return "SID" + paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String a(c paramc, String paramString) {
/*      */     c.a a1;
/*  763 */     return ((a1 = paramc.a(paramString)) != null) ? a(a1.a(0).intValue()) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private e a(d paramd, c paramc) {
/*      */     int i;
/*      */     int j;
/*  771 */     switch (j = (i = paramd.i()) & 0x7F) {
/*      */       
/*      */       case 0:
/*  774 */         return a(paramd, paramc, i);
/*      */       case 1:
/*  776 */         return b(paramd, paramc, i);
/*      */     } 
/*  778 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private g a(d paramd, c paramc, int paramInt) {
/*      */     g g;
/*  786 */     g.a(g = new g((byte)0), paramInt);
/*  787 */     g.b(g, paramd.i());
/*  788 */     g.a(0, ".notdef");
/*  789 */     for (byte b = 1; b <= g.a(g); b++) {
/*      */       
/*  791 */       int i = paramd.i();
/*  792 */       int j = paramc.a(b);
/*  793 */       g.a(i, a(j));
/*      */     } 
/*  795 */     if ((paramInt & 0x80) != 0)
/*      */     {
/*  797 */       a(paramd, g);
/*      */     }
/*  799 */     return g;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private j b(d paramd, c paramc, int paramInt) {
/*      */     j j;
/*  806 */     j.a(j = new j((byte)0), paramInt);
/*  807 */     j.b(j, paramd.i());
/*  808 */     j.a(0, ".notdef");
/*  809 */     byte b1 = 1;
/*  810 */     for (byte b2 = 0; b2 < j.a(j); b2++) {
/*      */       
/*  812 */       int i = paramd.i();
/*  813 */       int k = paramd.i();
/*  814 */       for (byte b = 0; b < k + 1; b++) {
/*      */         
/*  816 */         int m = paramc.a(b1);
/*  817 */         int n = i + b;
/*  818 */         j.a(n, a(m));
/*  819 */         b1++;
/*      */       } 
/*      */     } 
/*  822 */     if ((paramInt & 0x80) != 0)
/*      */     {
/*  824 */       a(paramd, j);
/*      */     }
/*  826 */     return j;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(d paramd, b paramb) {
/*  831 */     b.a(paramb, paramd.i());
/*  832 */     b.a(paramb, new b.a[b.a(paramb)]);
/*  833 */     for (byte b1 = 0; b1 < (b.b(paramb)).length; b1++) {
/*      */       b.a a1;
/*      */       
/*  836 */       b.a.a(a1 = new b.a(), paramd.i());
/*  837 */       b.a.b(a1, paramd.l());
/*  838 */       a(b.a.a(a1));
/*  839 */       b.b(paramb)[b1] = a1;
/*  840 */       b.a.a(a1); paramb.a(b.a.b(a1), a(b.a.a(a1)));
/*      */     } 
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
/*      */   private static s a(d paramd, int paramInt, a parama) {
/*      */     int i;
/*  855 */     switch (i = paramd.i()) {
/*      */       
/*      */       case 0:
/*  858 */         return a(paramd, i, paramInt, parama);
/*      */       case 3:
/*  860 */         return b(paramd, i, parama);
/*      */     } 
/*  862 */     throw new IllegalArgumentException();
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
/*      */   private static h a(d paramd, int paramInt1, int paramInt2, a parama) {
/*      */     h h;
/*  880 */     h.a(h = new h(parama, (byte)0), new int[paramInt2]);
/*  881 */     for (paramInt2 = 0; paramInt2 < (h.a(h)).length; paramInt2++)
/*      */     {
/*  883 */       h.a(h)[paramInt2] = paramd.i();
/*      */     }
/*  885 */     return h;
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
/*      */   private static l b(d paramd, int paramInt, a parama) {
/*      */     l l1;
/*  902 */     l.a(l1 = new l(parama, (byte)0), paramInt);
/*  903 */     l.b(l1, paramd.j());
/*      */     
/*  905 */     l.a(l1, new n[l.a(l1)]);
/*  906 */     for (paramInt = 0; paramInt < l.a(l1); paramInt++) {
/*      */       n n;
/*      */       
/*  909 */       n.a(n = new n((byte)0), paramd.j());
/*  910 */       n.b(n, paramd.i());
/*  911 */       l.b(l1)[paramInt] = n;
/*      */     } 
/*      */ 
/*      */     
/*  915 */     l.c(l1, paramd.j());
/*  916 */     return l1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class l
/*      */     extends s
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private int b;
/*      */     
/*      */     private l.n[] c;
/*      */     private int d;
/*      */     
/*      */     private l(a param1a) {
/*  931 */       super(param1a);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final int a(int param1Int) {
/*  937 */       for (byte b = 0; b < this.b; b++) {
/*      */         
/*  939 */         if (l.n.a(this.c[b]) <= param1Int)
/*      */         {
/*  941 */           if (b + 1 < this.b) {
/*      */             
/*  943 */             if (l.n.a(this.c[b + 1]) > param1Int)
/*      */             {
/*  945 */               return l.n.b(this.c[b]);
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */           else {
/*      */             
/*  952 */             if (this.d > param1Int)
/*      */             {
/*  954 */               return l.n.b(this.c[b]);
/*      */             }
/*  956 */             return -1;
/*      */           } 
/*      */         }
/*      */       } 
/*  960 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/*  966 */       return getClass().getName() + "[format=" + this.a + " nbRanges=" + this.b + ", range3=" + 
/*  967 */         Arrays.toString((Object[])this.c) + " sentinel=" + this.d + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class n
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private int b;
/*      */ 
/*      */     
/*      */     private n() {}
/*      */     
/*      */     public final String toString() {
/*  982 */       return getClass().getName() + "[first=" + this.a + ", fd=" + this.b + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class h
/*      */     extends s
/*      */   {
/*      */     private int[] a;
/*      */ 
/*      */ 
/*      */     
/*      */     private h(a param1a) {
/*  997 */       super(param1a);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final int a(int param1Int) {
/* 1003 */       if (param1Int < this.a.length)
/*      */       {
/* 1005 */         return this.a[param1Int];
/*      */       }
/* 1007 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1013 */       return getClass().getName() + "[fds=" + Arrays.toString(this.a) + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private c a(d paramd, int paramInt, boolean paramBoolean) {
/*      */     int i;
/* 1021 */     switch (i = paramd.i()) {
/*      */       
/*      */       case 0:
/* 1024 */         return a(paramd, i, paramInt, paramBoolean);
/*      */       case 1:
/* 1026 */         return b(paramd, i, paramInt, paramBoolean);
/*      */       case 2:
/* 1028 */         return c(paramd, i, paramInt, paramBoolean);
/*      */     } 
/* 1030 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private f a(d paramd, int paramInt1, int paramInt2, boolean paramBoolean) {
/*      */     f f;
/* 1038 */     f.a(f = new f(paramBoolean), paramInt1);
/* 1039 */     if (paramBoolean) {
/*      */       
/* 1041 */       f.a(0, 0);
/*      */     }
/*      */     else {
/*      */       
/* 1045 */       f.a(0, 0, ".notdef");
/*      */     } 
/*      */     
/* 1048 */     for (paramInt1 = 1; paramInt1 < paramInt2; paramInt1++) {
/*      */       
/* 1050 */       int i = paramd.l();
/* 1051 */       if (paramBoolean) {
/*      */         
/* 1053 */         f.a(paramInt1, i);
/*      */       }
/*      */       else {
/*      */         
/* 1057 */         f.a(paramInt1, i, a(i));
/*      */       } 
/*      */     } 
/* 1060 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private i b(d paramd, int paramInt1, int paramInt2, boolean paramBoolean) {
/*      */     i i;
/* 1067 */     i.a(i = new i(paramBoolean), paramInt1);
/* 1068 */     if (paramBoolean) {
/*      */       
/* 1070 */       i.a(0, 0);
/* 1071 */       i.a(i, new ArrayList());
/*      */     }
/*      */     else {
/*      */       
/* 1075 */       i.a(0, 0, ".notdef");
/*      */     } 
/*      */     
/* 1078 */     for (paramInt1 = 1; paramInt1 < paramInt2; paramInt1++) {
/*      */       
/* 1080 */       int j = paramd.l();
/* 1081 */       int k = paramd.i();
/* 1082 */       if (!paramBoolean) {
/*      */         
/* 1084 */         for (byte b = 0; b < k + 1; b++)
/*      */         {
/* 1086 */           int m = j + b;
/* 1087 */           i.a(paramInt1 + b, m, a(m));
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1092 */         i.a(i).add(new o(paramInt1, j, k, (byte)0));
/*      */       } 
/* 1094 */       paramInt1 += k;
/*      */     } 
/* 1096 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private k c(d paramd, int paramInt1, int paramInt2, boolean paramBoolean) {
/*      */     k k;
/* 1103 */     k.a(k = new k(paramBoolean), paramInt1);
/* 1104 */     if (paramBoolean) {
/*      */       
/* 1106 */       k.a(0, 0);
/* 1107 */       k.a(k, new ArrayList());
/*      */     }
/*      */     else {
/*      */       
/* 1111 */       k.a(0, 0, ".notdef");
/*      */     } 
/*      */     
/* 1114 */     for (paramInt1 = 1; paramInt1 < paramInt2; paramInt1++) {
/*      */       
/* 1116 */       int i = paramd.l();
/* 1117 */       int j = paramd.j();
/* 1118 */       if (!paramBoolean) {
/*      */         
/* 1120 */         for (byte b = 0; b < j + 1; b++)
/*      */         {
/* 1122 */           int m = i + b;
/* 1123 */           k.a(paramInt1 + b, m, a(m));
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1128 */         k.a(k).add(new o(paramInt1, i, j, (byte)0));
/*      */       } 
/* 1130 */       paramInt1 += j;
/*      */     } 
/* 1132 */     return k;
/*      */   }
/*      */ 
/*      */   
/*      */   private static class m
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private int b;
/*      */     
/*      */     private int c;
/*      */     private int d;
/*      */     
/*      */     private m() {}
/*      */     
/*      */     public final String toString() {
/* 1148 */       return getClass().getName() + "[major=" + this.a + ", minor=" + this.b + ", hdrSize=" + this.c + ", offSize=" + this.d + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class c
/*      */   {
/* 1158 */     private final Map<String, a> a = new HashMap<String, a>();
/*      */ 
/*      */     
/*      */     public final void a(a param1a) {
/* 1162 */       if (a.b(param1a) != null)
/*      */       {
/* 1164 */         this.a.put(a.b(param1a).a(), param1a);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public final a a(String param1String) {
/* 1170 */       return this.a.get(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public final Boolean a(String param1String, boolean param1Boolean) {
/*      */       a a;
/* 1176 */       return Boolean.valueOf(((a = a(param1String)) != null && !a.a().isEmpty()) ? a.b(0).booleanValue() : false);
/*      */     }
/*      */ 
/*      */     
/*      */     public final List<Number> a(String param1String, List<Number> param1List) {
/*      */       a a;
/* 1182 */       if ((a = a(param1String)) != null && !a.a().isEmpty()) return a.a();  return param1List;
/*      */     }
/*      */ 
/*      */     
/*      */     public final Number a(String param1String, Number param1Number) {
/*      */       a a;
/* 1188 */       if ((a = a(param1String)) != null && !a.a().isEmpty()) return a.a(0);  return param1Number;
/*      */     }
/*      */ 
/*      */     
/*      */     public final List<Number> b(String param1String, List<Number> param1List) {
/*      */       a a;
/* 1194 */       if ((a = a(param1String)) != null && !a.a().isEmpty()) return a.b();  return param1List;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1203 */       return getClass().getName() + "[entries=" + this.a + "]";
/*      */     }
/*      */ 
/*      */     
/*      */     private c() {}
/*      */     
/*      */     static class a
/*      */     {
/* 1211 */       private List<Number> a = new ArrayList<Number>();
/* 1212 */       private k b = null;
/*      */ 
/*      */       
/*      */       public final Number a(int param2Int) {
/* 1216 */         return this.a.get(param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       public final Boolean b(int param2Int) {
/*      */         Number number;
/* 1222 */         if (number = this.a.get(0) instanceof Integer)
/*      */         {
/* 1224 */           switch (number.intValue()) {
/*      */             
/*      */             case 0:
/* 1227 */               return Boolean.FALSE;
/*      */             case 1:
/* 1229 */               return Boolean.TRUE;
/*      */           } 
/*      */ 
/*      */         
/*      */         }
/* 1234 */         throw new IllegalArgumentException();
/*      */       }
/*      */ 
/*      */       
/*      */       public final List<Number> a() {
/* 1239 */         return this.a;
/*      */       }
/*      */ 
/*      */       
/*      */       public final List<Number> b() {
/* 1244 */         ArrayList<Number> arrayList = new ArrayList<Number>(this.a);
/* 1245 */         for (byte b = 1; b < arrayList.size(); b++) {
/*      */           
/* 1247 */           Number number1 = arrayList.get(b - 1);
/* 1248 */           Number number2 = arrayList.get(b);
/* 1249 */           number1 = Integer.valueOf(number1.intValue() + number2.intValue());
/* 1250 */           arrayList.set(b, number1);
/*      */         } 
/* 1252 */         return arrayList;
/*      */       }
/*      */       
/*      */       private a() {}
/*      */       
/*      */       public final String toString() {
/* 1258 */         return getClass().getName() + "[operands=" + this.a + ", operator=" + this.b + "]"; } } } private static class a { private List<Number> a; public final String toString() { return getClass().getName() + "[operands=" + this.a + ", operator=" + this.b + "]"; }
/*      */     
/*      */     private k b;
/*      */     private a() {
/*      */       this.a = new ArrayList<Number>();
/*      */       this.b = null;
/*      */     }
/*      */     public final Number a(int param1Int) {
/*      */       return this.a.get(param1Int);
/*      */     }
/*      */     public final Boolean b(int param1Int) {
/*      */       Number number;
/*      */       if (number = this.a.get(0) instanceof Integer)
/*      */         switch (number.intValue()) {
/*      */           case 0:
/*      */             return Boolean.FALSE;
/*      */           case 1:
/*      */             return Boolean.TRUE;
/*      */         }  
/*      */       throw new IllegalArgumentException();
/*      */     }
/*      */     public final List<Number> a() {
/*      */       return this.a;
/*      */     }
/*      */     public final List<Number> b() {
/*      */       ArrayList<Number> arrayList = new ArrayList<Number>(this.a);
/*      */       for (byte b = 1; b < arrayList.size(); b++) {
/*      */         Number number1 = arrayList.get(b - 1);
/*      */         Number number2 = arrayList.get(b);
/*      */         number1 = Integer.valueOf(number1.intValue() + number2.intValue());
/*      */         arrayList.set(b, number1);
/*      */       } 
/*      */       return arrayList;
/*      */     } }
/*      */   static abstract class b extends e { private int a; private a[] b;
/*      */     
/*      */     static class a { private int a;
/*      */       private int b;
/*      */       
/*      */       public final String toString() {
/* 1298 */         return getClass().getName() + "[code=" + this.a + ", sid=" + this.b + "]"; } } } static class a { private int a; private int b; public final String toString() { return getClass().getName() + "[code=" + this.a + ", sid=" + this.b + "]"; }
/*      */      }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class g
/*      */     extends b
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private int b;
/*      */ 
/*      */     
/*      */     private g() {}
/*      */     
/*      */     public final String toString() {
/* 1314 */       return getClass().getName() + "[format=" + this.a + ", nCodes=" + this.b + ", supplement=" + 
/* 1315 */         Arrays.toString((Object[])l.b.b(this)) + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class j
/*      */     extends b
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private int b;
/*      */     
/*      */     private j() {}
/*      */     
/*      */     public final String toString() {
/* 1330 */       return getClass().getName() + "[format=" + this.a + ", nRanges=" + this.b + ", supplement=" + 
/* 1331 */         Arrays.toString((Object[])l.b.b(this)) + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class d
/*      */     extends c
/*      */   {
/*      */     protected d(boolean param1Boolean) {
/* 1342 */       super(param1Boolean);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class e
/*      */     extends d
/*      */   {
/*      */     protected e(int param1Int) {
/* 1353 */       super(true);
/* 1354 */       a(0, 0);
/*      */ 
/*      */       
/* 1357 */       for (byte b = 1; b <= param1Int; b++)
/*      */       {
/* 1359 */         a(b, b);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1366 */       return getClass().getName();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class f
/*      */     extends d
/*      */   {
/*      */     private int a;
/*      */ 
/*      */     
/*      */     protected f(boolean param1Boolean) {
/* 1379 */       super(param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1385 */       return getClass().getName() + "[format=" + this.a + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class i
/*      */     extends d
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private List<l.o> b;
/*      */ 
/*      */     
/*      */     protected i(boolean param1Boolean) {
/* 1399 */       super(param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int c(int param1Int) {
/* 1421 */       if (a())
/*      */       {
/* 1423 */         for (Iterator<l.o> iterator = this.b.iterator(); iterator.hasNext();) {
/*      */           
/* 1425 */           if ((o = iterator.next()).a(param1Int))
/*      */           {
/* 1427 */             return o.b(param1Int);
/*      */           }
/*      */         } 
/*      */       }
/* 1431 */       return super.c(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1437 */       return getClass().getName() + "[format=" + this.a + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class k
/*      */     extends d
/*      */   {
/*      */     private int a;
/*      */     
/*      */     private List<l.o> b;
/*      */ 
/*      */     
/*      */     protected k(boolean param1Boolean) {
/* 1451 */       super(param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int c(int param1Int) {
/* 1470 */       for (Iterator<l.o> iterator = this.b.iterator(); iterator.hasNext();) {
/*      */         
/* 1472 */         if ((o = iterator.next()).a(param1Int))
/*      */         {
/* 1474 */           return o.b(param1Int);
/*      */         }
/*      */       } 
/* 1477 */       return super.c(param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1483 */       return getClass().getName() + "[format=" + this.a + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class o
/*      */   {
/*      */     private final int a;
/*      */     
/*      */     private final int b;
/*      */     
/*      */     private final int c;
/*      */     
/*      */     private final int d;
/*      */ 
/*      */     
/*      */     private o(int param1Int1, int param1Int2, int param1Int3) {
/* 1500 */       this.a = param1Int1;
/* 1501 */       this.b = this.a + param1Int3;
/* 1502 */       this.c = param1Int2;
/* 1503 */       this.d = this.c + param1Int3;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean a(int param1Int) {
/* 1513 */       return (param1Int >= this.c && param1Int <= this.d);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final int b(int param1Int) {
/* 1530 */       if (a(param1Int))
/*      */       {
/* 1532 */         return this.a + param1Int - this.c;
/*      */       }
/*      */ 
/*      */       
/* 1536 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1543 */       return getClass().getName() + "[start value=" + this.a + ", end value=" + this.b + ", start mapped-value=" + this.c + ", end mapped-value=" + this.d + "]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1550 */     return getClass().getSimpleName() + "[" + this.d + "]";
/*      */   }
/*      */   
/*      */   public static interface a {}
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */