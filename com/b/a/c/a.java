/*      */ package com.b.a.c;
/*      */ 
/*      */ import com.b.a.a.z;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class a
/*      */ {
/*      */   private final int a;
/*      */   private boolean b;
/*      */   private boolean c;
/*      */   private char d;
/*      */   
/*      */   private int a(char[] paramArrayOfchar1, int paramInt1, int paramInt2, char[] paramArrayOfchar2, int paramInt3, int paramInt4) {
/*   90 */     if (paramArrayOfchar1 == null) {
/*   91 */       throw new IllegalArgumentException("source can not be null");
/*      */     }
/*   93 */     if (paramInt2 < 0 || paramInt2 + 0 > paramArrayOfchar1.length) {
/*   94 */       throw new IllegalArgumentException("bad source start (" + Character.MIN_VALUE + ") or length (" + paramInt2 + ") for buffer of length " + paramArrayOfchar1.length);
/*      */     }
/*      */ 
/*      */     
/*   98 */     if (paramArrayOfchar2 == null && paramInt4 != 0) {
/*   99 */       throw new IllegalArgumentException("null dest requires destSize == 0");
/*      */     }
/*  101 */     if (paramInt4 != 0 && (paramInt4 < 0 || paramInt4 + 0 > paramArrayOfchar2.length))
/*      */     {
/*  103 */       throw new IllegalArgumentException("bad dest start (" + Character.MIN_VALUE + ") or size (" + paramInt4 + ") for buffer of length " + paramArrayOfchar2.length);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  108 */     if ((this.a & 0xE0000) != 0 && (this.a & 0xE0000) != 262144 && (this.a & 0xE0000) != 393216 && (this.a & 0xE0000) != 524288 && (this.a & 0xE0000) != 786432)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  113 */       throw new IllegalArgumentException("Wrong Tashkeel argument");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  118 */     if ((this.a & 0x10003) != 0 && (this.a & 0x10003) != 3 && (this.a & 0x10003) != 2 && (this.a & 0x10003) != 0 && (this.a & 0x10003) != 65536 && (this.a & 0x10003) != 1)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  124 */       throw new IllegalArgumentException("Wrong Lam Alef argument");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  129 */     if ((this.a & 0xE0000) != 0 && (this.a & 0x18) == 16) {
/*  130 */       throw new IllegalArgumentException("Tashkeel replacement should not be enabled in deshaping mode ");
/*      */     }
/*  132 */     return b(paramArrayOfchar1, 0, paramInt2, paramArrayOfchar2, 0, paramInt4);
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
/*      */   public final String a(String paramString) {
/*  162 */     char[] arrayOfChar1 = paramString.toCharArray(), arrayOfChar2 = arrayOfChar1;
/*  163 */     if ((this.a & 0x10003) == 0 && (this.a & 0x18) == 16)
/*      */     {
/*      */       
/*  166 */       arrayOfChar2 = new char[arrayOfChar1.length << 1];
/*      */     }
/*  168 */     int i = a(arrayOfChar1, 0, arrayOfChar1.length, arrayOfChar2, 0, arrayOfChar2.length);
/*      */     
/*  170 */     return new String(arrayOfChar2, 0, i);
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
/*      */   public a(int paramInt) {
/*  190 */     this.a = paramInt;
/*  191 */     if ((paramInt & 0xE0) > 128) {
/*  192 */       throw new IllegalArgumentException("bad DIGITS options");
/*      */     }
/*      */     
/*  195 */     this.b = ((paramInt & 0x4) == 0);
/*      */     
/*  197 */     this.c = ((paramInt & 0x4000000) == 67108864);
/*  198 */     if ((paramInt & 0x8000000) == 134217728) {
/*  199 */       this.d = 'ﹳ'; return;
/*      */     } 
/*  201 */     this.d = '​';
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
/*      */   public final boolean equals(Object paramObject) {
/*  587 */     if (paramObject != null && paramObject
/*  588 */       .getClass() == a.class && this.a == ((a)paramObject).a) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int hashCode() {
/*  598 */     return this.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toString() {
/*      */     StringBuilder stringBuilder;
/*  607 */     (stringBuilder = new StringBuilder(super.toString())).append('[');
/*      */     
/*  609 */     switch (this.a & 0x10003) { case 0:
/*  610 */         stringBuilder.append("LamAlef resize"); break;
/*  611 */       case 1: stringBuilder.append("LamAlef spaces at near"); break;
/*  612 */       case 3: stringBuilder.append("LamAlef spaces at begin"); break;
/*  613 */       case 2: stringBuilder.append("LamAlef spaces at end"); break;
/*  614 */       case 65536: stringBuilder.append("lamAlef auto"); break; }
/*      */     
/*  616 */     switch (this.a & 0x4) { case 0:
/*  617 */         stringBuilder.append(", logical"); break;
/*  618 */       case 4: stringBuilder.append(", visual"); break; }
/*      */     
/*  620 */     switch (this.a & 0x18) { case 0:
/*  621 */         stringBuilder.append(", no letter shaping"); break;
/*  622 */       case 8: stringBuilder.append(", shape letters"); break;
/*  623 */       case 24: stringBuilder.append(", shape letters tashkeel isolated"); break;
/*  624 */       case 16: stringBuilder.append(", unshape letters"); break; }
/*      */     
/*  626 */     switch (this.a & 0x700000) { case 2097152:
/*  627 */         stringBuilder.append(", Seen at near"); break; }
/*      */     
/*  629 */     switch (this.a & 0x3800000) { case 16777216:
/*  630 */         stringBuilder.append(", Yeh Hamza at near"); break; }
/*      */     
/*  632 */     switch (this.a & 0xE0000) { case 262144:
/*  633 */         stringBuilder.append(", Tashkeel at begin"); break;
/*  634 */       case 393216: stringBuilder.append(", Tashkeel at end"); break;
/*  635 */       case 786432: stringBuilder.append(", Tashkeel replace with tatweel"); break;
/*  636 */       case 524288: stringBuilder.append(", Tashkeel resize");
/*      */         break; }
/*      */     
/*  639 */     switch (this.a & 0xE0) { case 0:
/*  640 */         stringBuilder.append(", no digit shaping"); break;
/*  641 */       case 32: stringBuilder.append(", shape digits to AN"); break;
/*  642 */       case 64: stringBuilder.append(", shape digits to EN"); break;
/*  643 */       case 96: stringBuilder.append(", shape digits to AN contextually: default EN"); break;
/*  644 */       case 128: stringBuilder.append(", shape digits to AN contextually: default AL"); break; }
/*      */     
/*  646 */     switch (this.a & 0x100) { case 0:
/*  647 */         stringBuilder.append(", standard Arabic-Indic digits"); break;
/*  648 */       case 256: stringBuilder.append(", extended Arabic-Indic digits"); break; }
/*      */     
/*  650 */     stringBuilder.append("]");
/*      */     
/*  652 */     return stringBuilder.toString();
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
/*  668 */   private static final int[] e = new int[] { 0, 2, 4, 6, 8, 10, 12, 14 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  685 */   private static final int[] f = new int[] { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  702 */   private static final int[] g = new int[] { 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  721 */   private static final char[] h = new char[] { 'ﻯ', 'ﻰ' };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  727 */   private static final char[] i = new char[] { 'آ', 'أ', 'إ', 'ا' };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  734 */   private static final int[] j = new int[] { 4385, 4897, 5377, 5921, 6403, 7457, 7939, 8961, 9475, 10499, 11523, 12547, 13571, 14593, 15105, 15617, 16129, 16643, 17667, 18691, 19715, 20739, 21763, 22787, 23811, 0, 0, 0, 0, 0, 3, 24835, 25859, 26883, 27923, 28931, 29955, 30979, 32001, 32513, 33027, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 34049, 34561, 35073, 35585, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 33, 33, 0, 33, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 3, 3, 3, 1, 1 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  812 */   private static final int[] k = new int[] { 3, 3, 3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 32, 33, 32, 33, 0, 1, 32, 33, 0, 2, 3, 1, 32, 33, 0, 2, 3, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 16, 18, 19, 17, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  853 */   private static int[] l = new int[] { 1611, 1611, 1612, 1612, 1613, 1613, 1614, 1614, 1615, 1615, 1616, 1616, 1617, 1617, 1618, 1618, 1569, 1570, 1570, 1571, 1571, 1572, 1572, 1573, 1573, 1574, 1574, 1574, 1574, 1575, 1575, 1576, 1576, 1576, 1576, 1577, 1577, 1578, 1578, 1578, 1578, 1579, 1579, 1579, 1579, 1580, 1580, 1580, 1580, 1581, 1581, 1581, 1581, 1582, 1582, 1582, 1582, 1583, 1583, 1584, 1584, 1585, 1585, 1586, 1586, 1587, 1587, 1587, 1587, 1588, 1588, 1588, 1588, 1589, 1589, 1589, 1589, 1590, 1590, 1590, 1590, 1591, 1591, 1591, 1591, 1592, 1592, 1592, 1592, 1593, 1593, 1593, 1593, 1594, 1594, 1594, 1594, 1601, 1601, 1601, 1601, 1602, 1602, 1602, 1602, 1603, 1603, 1603, 1603, 1604, 1604, 1604, 1604, 1605, 1605, 1605, 1605, 1606, 1606, 1606, 1606, 1607, 1607, 1607, 1607, 1608, 1608, 1609, 1609, 1610, 1610, 1610, 1610, 1628, 1628, 1629, 1629, 1630, 1630, 1631, 1631 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  866 */   private static final int[][][] m = new int[][][] { { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 3 }, { 0, 1, 0, 1 } }, { { 0, 0, 2, 2 }, { 0, 0, 1, 2 }, { 0, 1, 1, 2 }, { 0, 1, 1, 3 } }, { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 3 }, { 0, 1, 0, 3 } }, { { 0, 0, 1, 2 }, { 0, 0, 1, 2 }, { 0, 1, 1, 2 }, { 0, 1, 1, 3 } } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(char[] paramArrayOfchar, int paramInt1, int paramInt2, char paramChar, boolean paramBoolean) {
/*  883 */     z z = z.a;
/*  884 */     paramChar = (char)(paramChar - 48);
/*      */     
/*  886 */     for (paramInt2 += 0; --paramInt2 >= 0; ) {
/*  887 */       char c = paramArrayOfchar[paramInt2];
/*  888 */       switch (z.a(c)) {
/*      */         case 0:
/*      */         case 1:
/*  891 */           paramBoolean = false;
/*      */         
/*      */         case 13:
/*  894 */           paramBoolean = true;
/*      */         
/*      */         case 2:
/*  897 */           if (paramBoolean && c <= '9') {
/*  898 */             paramArrayOfchar[paramInt2] = (char)(c + paramChar);
/*      */           }
/*      */       } 
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
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  917 */     for (paramInt1 = 0, paramInt2 = paramInt2 + 0 - 1; paramInt1 < paramInt2; paramInt1++, paramInt2--) {
/*  918 */       char c = paramArrayOfchar[paramInt1];
/*  919 */       paramArrayOfchar[paramInt1] = paramArrayOfchar[paramInt2];
/*  920 */       paramArrayOfchar[paramInt2] = c;
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
/*      */   private static char a(char paramChar) {
/*  933 */     switch (paramChar) { case 'آ':
/*  934 */         return 'ٜ';
/*  935 */       case 'أ': return 'ٝ';
/*  936 */       case 'إ': return 'ٞ';
/*  937 */       case 'ا': return 'ٟ'; }
/*  938 */      return Character.MIN_VALUE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int b(char paramChar) {
/*  948 */     if ((paramChar > 'ء' && paramChar < 'ئ') || paramChar == 'ا' || (paramChar > 'خ' && paramChar < 'س') || (paramChar > 'ه' && paramChar < 'ي') || paramChar == 'ة')
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  953 */       return 1; } 
/*  954 */     if (paramChar >= 'ً' && paramChar <= 'ْ')
/*  955 */       return 2; 
/*  956 */     if ((paramChar >= 'ٓ' && paramChar <= 'ٕ') || paramChar == 'ٰ' || (paramChar >= 'ﹰ' && paramChar <= 'ﹿ'))
/*      */     {
/*      */       
/*  959 */       return 3;
/*      */     }
/*  961 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int c(char paramChar) {
/*  972 */     if (paramChar >= 'آ' && paramChar <= 'ۓ')
/*  973 */       return j[paramChar - 1570]; 
/*  974 */     if (paramChar == '‍')
/*  975 */       return 3; 
/*  976 */     if (paramChar >= '⁭' && paramChar <= '⁯')
/*  977 */       return 4; 
/*  978 */     if (paramChar >= 'ﹰ' && paramChar <= 'ﻼ') {
/*  979 */       return k[paramChar - 65136];
/*      */     }
/*  981 */     return 0;
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
/*      */   private static int b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  993 */     for (int i = paramInt1, j = paramInt1 + paramInt2; i < j; i++) {
/*  994 */       if (paramArrayOfchar[i] != ' ') {
/*  995 */         return i - paramInt1;
/*      */       }
/*      */     } 
/*  998 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int c(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1005 */     for (int i = paramInt1 + paramInt2; --i >= paramInt1;) {
/* 1006 */       if (paramArrayOfchar[i] != ' ') {
/* 1007 */         return paramInt1 + paramInt2 - 1 - i;
/*      */       }
/*      */     } 
/* 1010 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean d(char paramChar) {
/* 1018 */     return (paramChar >= 'ً' && paramChar <= 'ْ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int e(char paramChar) {
/* 1028 */     if (paramChar >= 'ﺱ' && paramChar < 'ﺿ') {
/* 1029 */       return f[paramChar - 65201];
/*      */     }
/* 1031 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int f(char paramChar) {
/* 1041 */     if (paramChar >= 'س' && paramChar <= 'ض') {
/* 1042 */       return 1;
/*      */     }
/* 1044 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean g(char paramChar) {
/* 1055 */     if (paramChar == '​' || paramChar == 'ﹳ') {
/* 1056 */       return true;
/*      */     }
/* 1058 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean h(char paramChar) {
/* 1068 */     return (paramChar == 'ﻯ' || paramChar == 'ﻰ' || paramChar == 'ى');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean i(char paramChar) {
/* 1077 */     if (paramChar == 'ﺉ' || paramChar == 'ﺊ') {
/* 1078 */       return true;
/*      */     }
/* 1080 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean j(char paramChar) {
/* 1090 */     return (paramChar != '﹵' && paramChar >= 'ﹰ' && paramChar <= 'ﹿ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int k(char paramChar) {
/* 1101 */     if (paramChar >= 'ﹰ' && paramChar <= 'ﹿ' && paramChar != 'ﹳ' && paramChar != '﹵' && paramChar != 'ﹽ')
/*      */     {
/* 1103 */       return g[paramChar - 65136]; } 
/* 1104 */     if ((paramChar >= 'ﳲ' && paramChar <= 'ﳴ') || paramChar == 'ﹽ') {
/* 1105 */       return 2;
/*      */     }
/* 1107 */     return 0;
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
/*      */   private static int l(char paramChar) {
/* 1119 */     if (paramChar >= 'ﹰ' && paramChar <= 'ﹿ' && paramChar != 'ﹳ' && paramChar != '﹵')
/* 1120 */       return 1 - g[paramChar - 65136]; 
/* 1121 */     if (paramChar >= 'ﱞ' && paramChar <= 'ﱣ') {
/* 1122 */       return 1;
/*      */     }
/* 1124 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean m(char paramChar) {
/* 1133 */     return (paramChar == 'آ' || paramChar == 'أ' || paramChar == 'إ' || paramChar == 'ا');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean n(char paramChar) {
/* 1141 */     return (paramChar >= 'ﻵ' && paramChar <= 'ﻼ');
/*      */   }
/*      */   
/*      */   private static boolean o(char paramChar) {
/* 1145 */     return (paramChar >= 'ٜ' && paramChar <= 'ٟ');
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
/*      */   private int d(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1157 */     int j, i = paramInt2;
/*      */     
/* 1159 */     switch (this.a & 0x18) {
/*      */       case 8:
/*      */       case 24:
/* 1162 */         if (this.b) {
/* 1163 */           for (int k = paramInt1; k < paramInt1; k++) {
/* 1164 */             if ((paramArrayOfchar[k] == 'ل' && m(paramArrayOfchar[k + 1])) || j(paramArrayOfchar[k]))
/* 1165 */               i--; 
/*      */           } 
/*      */           break;
/*      */         } 
/* 1169 */         for (j = paramInt1 + 1, paramInt1 += paramInt2; j < paramInt1; j++) {
/* 1170 */           if ((paramArrayOfchar[j] == 'ل' && m(paramArrayOfchar[j - 1])) || j(paramArrayOfchar[j])) {
/* 1171 */             i--;
/*      */           }
/*      */         } 
/*      */         break;
/*      */ 
/*      */       
/*      */       case 16:
/* 1178 */         for (j = paramInt1, paramInt1 += paramInt2; j < paramInt1; j++) {
/* 1179 */           if (n(paramArrayOfchar[j])) {
/* 1180 */             i++;
/*      */           }
/*      */         } 
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1189 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(char[] paramArrayOfchar, int paramInt, char paramChar) {
/* 1198 */     byte b1 = 0;
/* 1199 */     byte b2 = 0;
/* 1200 */     while (b1 < paramInt) {
/* 1201 */       if (paramArrayOfchar[b1] == paramChar) {
/* 1202 */         b2++;
/*      */       }
/* 1204 */       b1++;
/*      */     } 
/* 1206 */     return b2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void a(char[] paramArrayOfchar, int paramInt1, int paramInt2, char paramChar) {
/* 1214 */     int i = paramInt2;
/* 1215 */     paramInt2 = paramInt2;
/* 1216 */     while (--paramInt2 >= paramInt1) {
/*      */ 
/*      */       
/* 1219 */       i--; char c;
/* 1220 */       if ((c = paramArrayOfchar[paramInt2]) != paramChar && i != paramInt2) {
/* 1221 */         paramArrayOfchar[i] = c;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 1233 */     if (paramInt3 > paramInt1) {
/*      */       
/* 1235 */       int i = paramInt3;
/* 1236 */       paramInt3 = paramInt1;
/* 1237 */       while (i < paramInt2) {
/* 1238 */         paramArrayOfchar[paramInt3++] = paramArrayOfchar[i++];
/*      */       }
/*      */     } else {
/* 1241 */       paramInt3 = paramInt2;
/*      */     } 
/* 1243 */     return paramInt3;
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
/*      */   private static int a(char[] paramArrayOfchar, int paramInt) {
/* 1257 */     for (byte b = 0; b < paramInt; b++) {
/* 1258 */       if (k(paramArrayOfchar[b]) == 1) {
/* 1259 */         paramArrayOfchar[b] = 'ـ';
/* 1260 */       } else if (k(paramArrayOfchar[b]) == 2) {
/* 1261 */         paramArrayOfchar[b] = 'ﹽ';
/* 1262 */       } else if (l(paramArrayOfchar[b]) == 1 && paramArrayOfchar[b] != 'ﹼ') {
/* 1263 */         paramArrayOfchar[b] = ' ';
/*      */       } 
/*      */     } 
/* 1266 */     return paramInt;
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
/*      */   private int e(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1291 */     int i = this.a & 0x10003;
/* 1292 */     int j = this.a & 0xE0000;
/* 1293 */     boolean bool1 = false;
/* 1294 */     boolean bool2 = false;
/*      */     
/* 1296 */     if (((!this.b ? 1 : 0) & (!this.c ? 1 : 0)) != 0) {
/* 1297 */       switch (i) { case 3:
/* 1298 */           i = 2; break;
/* 1299 */         case 2: i = 3;
/*      */           break; }
/*      */       
/* 1302 */       switch (j) { case 262144:
/* 1303 */           j = 393216; break;
/* 1304 */         case 393216: j = 262144;
/*      */           break; }
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/* 1310 */     if (i == 1) {
/* 1311 */       int k; for (int m = (k = paramInt1) + paramInt2; k < m; k++) {
/* 1312 */         if (paramArrayOfchar[k] == Character.MAX_VALUE) {
/* 1313 */           paramArrayOfchar[k] = ' ';
/*      */         }
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1319 */       int k = paramInt1 + paramInt2;
/* 1320 */       int m = a(paramArrayOfchar, paramInt2, '￿');
/* 1321 */       int n = a(paramArrayOfchar, paramInt2, '￾');
/*      */       
/* 1323 */       if (i == 2) {
/* 1324 */         bool1 = true;
/*      */       }
/* 1326 */       if (j == 393216) {
/* 1327 */         bool2 = true;
/*      */       }
/*      */ 
/*      */       
/* 1331 */       if (bool1 && i == 2) {
/* 1332 */         a(paramArrayOfchar, paramInt1, k, '￿');
/* 1333 */         while (m > paramInt1) {
/* 1334 */           paramArrayOfchar[--m] = ' ';
/*      */         }
/*      */       } 
/*      */       
/* 1338 */       if (bool2 && j == 393216) {
/* 1339 */         a(paramArrayOfchar, paramInt1, k, '￾');
/* 1340 */         while (n > paramInt1) {
/* 1341 */           paramArrayOfchar[--n] = ' ';
/*      */         }
/*      */       } 
/*      */       
/* 1345 */       bool1 = false;
/* 1346 */       bool2 = false;
/*      */       
/* 1348 */       if (i == 0) {
/* 1349 */         bool1 = true;
/*      */       }
/* 1351 */       if (j == 524288) {
/* 1352 */         bool2 = true;
/*      */       }
/*      */       
/* 1355 */       if (bool1 && i == 0) {
/* 1356 */         a(paramArrayOfchar, paramInt1, k, '￿');
/*      */         
/* 1358 */         paramInt2 = (m = a(paramArrayOfchar, paramInt1, k, m)) - paramInt1;
/*      */       } 
/* 1360 */       if (bool2 && j == 524288) {
/* 1361 */         a(paramArrayOfchar, paramInt1, k, '￾');
/*      */         
/* 1363 */         paramInt2 = (n = a(paramArrayOfchar, paramInt1, k, n)) - paramInt1;
/*      */       } 
/*      */       
/* 1366 */       bool1 = false;
/* 1367 */       bool2 = false;
/*      */       
/* 1369 */       if (i == 3 || i == 65536)
/*      */       {
/* 1371 */         bool1 = true;
/*      */       }
/* 1373 */       if (j == 262144) {
/* 1374 */         bool2 = true;
/*      */       }
/*      */       
/* 1377 */       if (bool1 && (i == 3 || i == 65536)) {
/*      */         
/* 1379 */         a(paramArrayOfchar, paramInt1, k, '￿');
/* 1380 */         m = a(paramArrayOfchar, paramInt1, k, m);
/* 1381 */         while (m < k) {
/* 1382 */           paramArrayOfchar[m++] = ' ';
/*      */         }
/*      */       } 
/* 1385 */       if (bool2 && j == 262144) {
/* 1386 */         a(paramArrayOfchar, paramInt1, k, '￾');
/* 1387 */         n = a(paramArrayOfchar, paramInt1, k, n);
/* 1388 */         while (n < k) {
/* 1389 */           paramArrayOfchar[n++] = ' ';
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1394 */     return paramInt2;
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
/*      */   private static boolean b(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 1410 */     if (paramInt3 > c(paramArrayOfchar, paramInt1, paramInt2))
/*      */     {
/* 1412 */       return true;
/*      */     }
/* 1414 */     for (paramInt3 = paramInt1 + paramInt2 - paramInt3, paramInt2 = paramInt1 + paramInt2; --paramInt3 >= paramInt1; ) {
/*      */       char c;
/* 1416 */       if (o(c = paramArrayOfchar[paramInt3])) {
/* 1417 */         paramArrayOfchar[--paramInt2] = 'ل';
/* 1418 */         paramArrayOfchar[--paramInt2] = i[c - 1628]; continue;
/*      */       } 
/* 1420 */       paramArrayOfchar[--paramInt2] = c;
/*      */     } 
/*      */     
/* 1423 */     return false;
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
/*      */   private static boolean c(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 1440 */     if (paramInt3 > b(paramArrayOfchar, paramInt1, paramInt2))
/*      */     {
/* 1442 */       return true; } 
/*      */     int i;
/* 1444 */     for (paramInt3 = paramInt1 + paramInt3, i = paramInt1, paramInt1 += paramInt2; paramInt3 < paramInt1; paramInt3++) {
/*      */       
/* 1446 */       if (o(paramInt2 = paramArrayOfchar[paramInt3])) {
/* 1447 */         paramArrayOfchar[i++] = i[paramInt2 - 1628];
/* 1448 */         paramArrayOfchar[i++] = 'ل';
/*      */       } else {
/* 1450 */         paramArrayOfchar[i++] = paramInt2;
/*      */       } 
/*      */     } 
/* 1453 */     return false;
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
/*      */   private boolean a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1470 */     if (o(paramArrayOfchar[paramInt1]))
/*      */     {
/* 1472 */       return true;
/*      */     }
/* 1474 */     for (paramInt2 = paramInt1 + paramInt2; --paramInt2 >= paramInt1; ) {
/* 1475 */       char c = paramArrayOfchar[paramInt2];
/* 1476 */       if (paramInt5 == 1 && o(c)) {
/* 1477 */         if (paramInt2 > paramInt1 && paramArrayOfchar[paramInt2 - 1] == ' ') {
/* 1478 */           paramArrayOfchar[paramInt2] = 'ل';
/* 1479 */           paramArrayOfchar[--paramInt2] = i[c - 1628];
/*      */           continue;
/*      */         } 
/* 1482 */         return true;
/*      */       } 
/* 1484 */       if (paramInt4 == 1 && e(c) == 1) {
/* 1485 */         if (paramInt2 > paramInt1 && paramArrayOfchar[paramInt2 - 1] == ' ') {
/* 1486 */           paramArrayOfchar[paramInt2 - 1] = this.d;
/*      */           continue;
/*      */         } 
/* 1489 */         return true;
/*      */       } 
/* 1491 */       if (paramInt3 == 1 && i(c)) {
/*      */         
/* 1493 */         if (paramInt2 > paramInt1 && paramArrayOfchar[paramInt2 - 1] == ' ') {
/* 1494 */           paramArrayOfchar[paramInt2] = h[c - 65161];
/* 1495 */           paramArrayOfchar[paramInt2 - 1] = 'ﺀ';
/*      */           continue;
/*      */         } 
/* 1498 */         return true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1504 */     return false;
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
/*      */   private int a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1524 */     int i = this.a & 0x10003;
/* 1525 */     int j = this.a & 0x700000;
/* 1526 */     int k = this.a & 0x3800000;
/*      */ 
/*      */     
/* 1529 */     if (!this.b && !this.c) {
/* 1530 */       switch (i) { case 3:
/* 1531 */           i = 2; break;
/* 1532 */         case 2: i = 3;
/*      */           break; }
/*      */ 
/*      */     
/*      */     }
/* 1537 */     if (paramInt4 == 1) {
/* 1538 */       if (i == 65536) {
/* 1539 */         if (this.b) {
/*      */           boolean bool;
/* 1541 */           if (bool = c(paramArrayOfchar, paramInt1, paramInt2, paramInt3)) {
/* 1542 */             bool = b(paramArrayOfchar, paramInt1, paramInt2, paramInt3);
/*      */           }
/* 1544 */           if (bool) {
/* 1545 */             bool = a(paramArrayOfchar, paramInt1, paramInt2, 0, 0, 1);
/*      */           }
/* 1547 */           if (bool) {
/* 1548 */             throw new b("No spacefor lamalef");
/*      */           }
/*      */         } else {
/*      */           boolean bool;
/* 1552 */           if (bool = b(paramArrayOfchar, paramInt1, paramInt2, paramInt3)) {
/* 1553 */             bool = c(paramArrayOfchar, paramInt1, paramInt2, paramInt3);
/*      */           }
/* 1555 */           if (bool) {
/* 1556 */             bool = a(paramArrayOfchar, paramInt1, paramInt2, 0, 0, 1);
/*      */           }
/* 1558 */           if (bool) {
/* 1559 */             throw new b("No spacefor lamalef");
/*      */           }
/*      */         } 
/* 1562 */       } else if (i == 2) {
/*      */         boolean bool;
/* 1564 */         if (bool = c(paramArrayOfchar, paramInt1, paramInt2, paramInt3)) {
/* 1565 */           throw new b("No spacefor lamalef");
/*      */         }
/* 1567 */       } else if (i == 3) {
/*      */         boolean bool;
/* 1569 */         if (bool = b(paramArrayOfchar, paramInt1, paramInt2, paramInt3)) {
/* 1570 */           throw new b("No spacefor lamalef");
/*      */         }
/* 1572 */       } else if (i == 1) {
/*      */         boolean bool;
/* 1574 */         if (bool = a(paramArrayOfchar, paramInt1, paramInt2, 0, 0, 1)) {
/* 1575 */           throw new b("No spacefor lamalef");
/*      */         }
/* 1577 */       } else if (i == 0) {
/* 1578 */         for (i = (paramInt4 = paramInt1 + paramInt2) + paramInt3; --paramInt4 >= paramInt1; ) {
/*      */           
/* 1580 */           if (o(j = paramArrayOfchar[paramInt4])) {
/* 1581 */             paramArrayOfchar[--i] = 'ل';
/* 1582 */             paramArrayOfchar[--i] = i[j - 1628]; continue;
/*      */           } 
/* 1584 */           paramArrayOfchar[--i] = j;
/*      */         } 
/*      */         
/* 1587 */         paramInt2 += paramInt3;
/*      */       } 
/*      */     } else {
/* 1590 */       boolean bool; if (j == 2097152 && (
/*      */         
/* 1592 */         bool = a(paramArrayOfchar, paramInt1, paramInt2, 0, 1, 0))) {
/* 1593 */         throw new b("No space for Seen tail expansion");
/*      */       }
/*      */       
/* 1596 */       if (k == 16777216 && (
/*      */         
/* 1598 */         bool = a(paramArrayOfchar, paramInt1, paramInt2, 1, 0, 0))) {
/* 1599 */         throw new b("No space for YehHamza expansion");
/*      */       }
/*      */     } 
/*      */     
/* 1603 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int f(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1613 */     byte b = 0;
/* 1614 */     for (paramInt2 = (paramInt1 = paramInt1) + paramInt2; paramInt1 < paramInt2; paramInt1++) {
/*      */       char c;
/* 1616 */       if ((c = paramArrayOfchar[paramInt1]) >= 'ﹰ' && c <= 'ﻼ') {
/* 1617 */         if (n(c)) {
/* 1618 */           b++;
/*      */         }
/* 1620 */         paramArrayOfchar[paramInt1] = (char)l[c - 65136];
/*      */       } 
/*      */     } 
/* 1623 */     return b;
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
/*      */   private int g(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1636 */     byte b = 0;
/*      */ 
/*      */ 
/*      */     
/* 1640 */     boolean bool1 = ((this.a & 0x3800000) == 16777216) ? true : false;
/* 1641 */     boolean bool2 = ((this.a & 0x700000) == 2097152) ? true : false;
/*      */     
/* 1643 */     for (int i = (paramInt1 = paramInt1) + paramInt2; paramInt1 < i; paramInt1++) {
/* 1644 */       char c = paramArrayOfchar[paramInt1];
/*      */       
/* 1646 */       if (bool1 == true && (c == 'ء' || c == 'ﺀ') && paramInt1 < paramInt2 - 1 && 
/* 1647 */         h(paramArrayOfchar[paramInt1 + 1])) {
/* 1648 */         paramArrayOfchar[paramInt1] = ' ';
/* 1649 */         paramArrayOfchar[paramInt1 + 1] = 'ئ';
/* 1650 */       } else if (bool2 == true && g(c) && paramInt1 < paramInt2 - 1 && 
/* 1651 */         e(paramArrayOfchar[paramInt1 + 1]) == 1) {
/* 1652 */         paramArrayOfchar[paramInt1] = ' ';
/*      */       }
/* 1654 */       else if (c >= 'ﹰ' && c <= 'ﻼ') {
/* 1655 */         if (n(c)) {
/* 1656 */           b++;
/*      */         }
/* 1658 */         paramArrayOfchar[paramInt1] = (char)l[c - 65136];
/*      */       } 
/*      */     } 
/* 1661 */     return b;
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
/*      */   private int d(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 1675 */     int i = f(paramArrayOfchar, 0, paramInt2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1682 */     boolean bool1 = false, bool2 = false;
/* 1683 */     boolean bool3 = false, bool4 = false;
/* 1684 */     paramInt1 = paramInt2 + 0 - 1;
/* 1685 */     int j = c(paramArrayOfchar[paramInt1]);
/* 1686 */     int k = 0;
/* 1687 */     int m = 0;
/* 1688 */     int n = 0;
/*      */     
/* 1690 */     int i1 = paramInt1;
/* 1691 */     int i2 = -2;
/*      */ 
/*      */     
/* 1694 */     while (paramInt1 >= 0) {
/*      */       
/* 1696 */       if ((j & 0xFF00) != 0 || d(paramArrayOfchar[paramInt1])) {
/* 1697 */         int i3 = paramInt1 - 1;
/* 1698 */         i2 = -2;
/* 1699 */         while (i2 < 0) {
/* 1700 */           if (i3 == -1) {
/* 1701 */             k = 0;
/* 1702 */             i2 = Integer.MAX_VALUE;
/*      */             continue;
/*      */           } 
/* 1705 */           if (((k = c(paramArrayOfchar[i3])) & 0x4) == 0) {
/* 1706 */             i2 = i3; continue;
/*      */           } 
/* 1708 */           i3--;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1713 */         if ((j & 0x20) > 0 && (n & 0x10) > 0) {
/* 1714 */           bool1 = true;
/*      */           
/* 1716 */           if ((i3 = a(paramArrayOfchar[paramInt1])) != 0) {
/*      */             
/* 1718 */             paramArrayOfchar[paramInt1] = Character.MAX_VALUE;
/* 1719 */             paramArrayOfchar[i1] = i3;
/* 1720 */             paramInt1 = i1;
/*      */           } 
/*      */           
/* 1723 */           n = m;
/* 1724 */           j = c(i3);
/*      */         } 
/* 1726 */         if (paramInt1 > 0 && paramArrayOfchar[paramInt1 - 1] == ' ') {
/*      */           
/* 1728 */           if (f(paramArrayOfchar[paramInt1]) == 1) {
/* 1729 */             bool2 = true;
/* 1730 */           } else if (paramArrayOfchar[paramInt1] == 'ئ') {
/* 1731 */             bool3 = true;
/*      */           }
/*      */         
/* 1734 */         } else if (paramInt1 == 0) {
/* 1735 */           if (f(paramArrayOfchar[paramInt1]) == 1) {
/* 1736 */             bool2 = true;
/* 1737 */           } else if (paramArrayOfchar[paramInt1] == 'ئ') {
/* 1738 */             bool3 = true;
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1747 */         i3 = b(paramArrayOfchar[paramInt1]);
/*      */         
/* 1749 */         int i4 = m[k & 0x3][n & 0x3][j & 0x3];
/*      */ 
/*      */ 
/*      */         
/* 1753 */         if (i3 == 1) {
/* 1754 */           i4 &= 0x1;
/* 1755 */         } else if (i3 == 2) {
/* 1756 */           if (paramInt3 == 0 && (n & 0x2) != 0 && (k & 0x1) != 0 && paramArrayOfchar[paramInt1] != 'ٌ' && paramArrayOfchar[paramInt1] != 'ٍ' && ((k & 0x20) != 32 || (n & 0x10) != 16)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1764 */             i4 = 1;
/*      */           }
/* 1766 */           else if (paramInt3 == 2 && paramArrayOfchar[paramInt1] == 'ّ') {
/* 1767 */             i4 = 1;
/*      */           } else {
/*      */             
/* 1770 */             i4 = 0;
/*      */           } 
/*      */         } 
/* 1773 */         if (i3 == 2) {
/* 1774 */           if (paramInt3 == 2 && paramArrayOfchar[paramInt1] != 'ّ') {
/* 1775 */             paramArrayOfchar[paramInt1] = '￾';
/* 1776 */             bool4 = true;
/*      */           } else {
/*      */             
/* 1779 */             paramArrayOfchar[paramInt1] = (char)(65136 + e[paramArrayOfchar[paramInt1] - 1611] + i4);
/*      */           } 
/*      */         } else {
/*      */           
/* 1783 */           paramArrayOfchar[paramInt1] = (char)(65136 + (j >> 8) + i4);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1788 */       if ((j & 0x4) == 0) {
/* 1789 */         m = n;
/* 1790 */         n = j;
/*      */         
/* 1792 */         i1 = paramInt1;
/*      */       } 
/*      */       
/* 1795 */       paramInt1--;
/* 1796 */       if (paramInt1 == i2) {
/* 1797 */         j = k;
/* 1798 */         i2 = -2; continue;
/* 1799 */       }  if (paramInt1 != -1) {
/* 1800 */         j = c(paramArrayOfchar[paramInt1]);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1807 */     paramInt1 = paramInt2;
/* 1808 */     if (bool1 || bool4) {
/* 1809 */       paramInt1 = e(paramArrayOfchar, 0, paramInt2);
/*      */     }
/* 1811 */     if (bool2 || bool3) {
/* 1812 */       paramInt1 = a(paramArrayOfchar, 0, paramInt1, i, 0);
/*      */     }
/* 1814 */     return paramInt1;
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
/*      */   private int h(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*      */     int i;
/* 1830 */     if ((paramInt1 = g(paramArrayOfchar, 0, paramInt2)) != 0) {
/*      */       
/* 1832 */       i = a(paramArrayOfchar, 0, paramInt2, paramInt1, 1);
/*      */     } else {
/* 1834 */       i = paramInt2;
/*      */     } 
/*      */     
/* 1837 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int b(char[] paramArrayOfchar1, int paramInt1, int paramInt2, char[] paramArrayOfchar2, int paramInt3, int paramInt4) {
/* 1847 */     if (paramInt2 == 0) {
/* 1848 */       return 0;
/*      */     }
/*      */     
/* 1851 */     if (paramInt4 == 0) {
/* 1852 */       if ((this.a & 0x18) != 0 && (this.a & 0x10003) == 0)
/*      */       {
/*      */         
/* 1855 */         return d(paramArrayOfchar1, paramInt1, paramInt2);
/*      */       }
/* 1857 */       return paramInt2;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1862 */     char[] arrayOfChar = new char[paramInt2 << 1];
/* 1863 */     System.arraycopy(paramArrayOfchar1, paramInt1, arrayOfChar, 0, paramInt2);
/*      */     
/* 1865 */     if (this.b) {
/* 1866 */       a(arrayOfChar, 0, paramInt2);
/*      */     }
/*      */     
/* 1869 */     int i = paramInt2;
/*      */     
/* 1871 */     switch (this.a & 0x18) {
/*      */       case 24:
/* 1873 */         i = d(arrayOfChar, 0, paramInt2, 1);
/*      */         break;
/*      */       
/*      */       case 8:
/* 1877 */         if ((this.a & 0xE0000) != 0 && (this.a & 0xE0000) != 786432) {
/*      */ 
/*      */           
/* 1880 */           i = d(arrayOfChar, 0, paramInt2, 2);
/*      */           break;
/*      */         } 
/* 1883 */         i = d(arrayOfChar, 0, paramInt2, 0);
/*      */ 
/*      */         
/* 1886 */         if ((this.a & 0xE0000) == 786432) {
/* 1887 */           i = a(arrayOfChar, paramInt2);
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       case 16:
/* 1893 */         i = h(arrayOfChar, 0, paramInt2);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1900 */     if (i > paramInt4) {
/* 1901 */       throw new b("not enough room for result data");
/*      */     }
/*      */     
/* 1904 */     if ((this.a & 0xE0) != 0) {
/* 1905 */       byte b; paramInt1 = 48;
/* 1906 */       switch (this.a & 0x100) {
/*      */         case 0:
/* 1908 */           paramInt1 = 1632;
/*      */           break;
/*      */         
/*      */         case 256:
/* 1912 */           paramInt1 = 1776;
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1919 */       switch (this.a & 0xE0) {
/*      */         
/*      */         case 32:
/* 1922 */           paramInt2 = paramInt1 - 48;
/* 1923 */           for (paramInt4 = 0; paramInt4 < i; paramInt4++) {
/*      */             char c;
/* 1925 */             if ((c = arrayOfChar[paramInt4]) <= '9' && c >= '0') {
/* 1926 */               arrayOfChar[paramInt4] = (char)(arrayOfChar[paramInt4] + paramInt2);
/*      */             }
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 64:
/* 1934 */           paramInt2 = (char)(paramInt1 + 9);
/* 1935 */           paramInt4 = 48 - paramInt1;
/* 1936 */           for (b = 0; b < i; b++) {
/*      */             char c;
/* 1938 */             if ((c = arrayOfChar[b]) <= paramInt2 && c >= paramInt1) {
/* 1939 */               arrayOfChar[b] = (char)(arrayOfChar[b] + paramInt4);
/*      */             }
/*      */           } 
/*      */           break;
/*      */ 
/*      */         
/*      */         case 96:
/* 1946 */           a(arrayOfChar, 0, i, paramInt1, false);
/*      */           break;
/*      */         
/*      */         case 128:
/* 1950 */           a(arrayOfChar, 0, i, paramInt1, true);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/* 1958 */     if (this.b) {
/* 1959 */       a(arrayOfChar, 0, i);
/*      */     }
/*      */     
/* 1962 */     System.arraycopy(arrayOfChar, 0, paramArrayOfchar2, paramInt3, i);
/*      */     
/* 1964 */     return i;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */