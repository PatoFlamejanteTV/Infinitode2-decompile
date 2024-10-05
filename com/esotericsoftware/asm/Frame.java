package com.esotericsoftware.asm;

final class Frame {
  static final int[] a;
  
  Label b;
  
  int[] c;
  
  int[] d;
  
  private int[] e;
  
  private int[] f;
  
  private int g;
  
  private int h;
  
  private int[] i;
  
  private int a(int paramInt) {
    if (this.e == null || paramInt >= this.e.length)
      return 0x2000000 | paramInt; 
    int i;
    if ((i = this.e[paramInt]) == 0)
      i = this.e[paramInt] = 0x2000000 | paramInt; 
    return i;
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (this.e == null)
      this.e = new int[10]; 
    int i = this.e.length;
    if (paramInt1 >= i) {
      int[] arrayOfInt = new int[Math.max(paramInt1 + 1, 2 * i)];
      System.arraycopy(this.e, 0, arrayOfInt, 0, i);
      this.e = arrayOfInt;
    } 
    this.e[paramInt1] = paramInt2;
  }
  
  private void b(int paramInt) {
    if (this.f == null)
      this.f = new int[10]; 
    int i = this.f.length;
    if (this.g >= i) {
      int[] arrayOfInt = new int[Math.max(this.g + 1, 2 * i)];
      System.arraycopy(this.f, 0, arrayOfInt, 0, i);
      this.f = arrayOfInt;
    } 
    this.f[this.g++] = paramInt;
    int j;
    if ((j = this.b.f + this.g) > this.b.g)
      this.b.g = j; 
  }
  
  private void a(ClassWriter paramClassWriter, String paramString) {
    int i;
    if ((i = b(paramClassWriter, paramString)) != 0) {
      b(i);
      if (i == 16777220 || i == 16777219)
        b(16777216); 
    } 
  }
  
  private static int b(ClassWriter paramClassWriter, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokevirtual charAt : (I)C
    //   5: bipush #40
    //   7: if_icmpne -> 21
    //   10: aload_1
    //   11: bipush #41
    //   13: invokevirtual indexOf : (I)I
    //   16: iconst_1
    //   17: iadd
    //   18: goto -> 22
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual charAt : (I)C
    //   28: tableswitch default -> 181, 66 -> 146, 67 -> 146, 68 -> 155, 69 -> 181, 70 -> 149, 71 -> 181, 72 -> 181, 73 -> 146, 74 -> 152, 75 -> 181, 76 -> 158, 77 -> 181, 78 -> 181, 79 -> 181, 80 -> 181, 81 -> 181, 82 -> 181, 83 -> 146, 84 -> 181, 85 -> 181, 86 -> 144, 87 -> 181, 88 -> 181, 89 -> 181, 90 -> 146
    //   144: iconst_0
    //   145: ireturn
    //   146: ldc 16777217
    //   148: ireturn
    //   149: ldc 16777218
    //   151: ireturn
    //   152: ldc 16777220
    //   154: ireturn
    //   155: ldc 16777219
    //   157: ireturn
    //   158: aload_1
    //   159: iload_2
    //   160: iconst_1
    //   161: iadd
    //   162: aload_1
    //   163: invokevirtual length : ()I
    //   166: iconst_1
    //   167: isub
    //   168: invokevirtual substring : (II)Ljava/lang/String;
    //   171: astore_1
    //   172: ldc 24117248
    //   174: aload_0
    //   175: aload_1
    //   176: invokevirtual c : (Ljava/lang/String;)I
    //   179: ior
    //   180: ireturn
    //   181: iload_2
    //   182: iconst_1
    //   183: iadd
    //   184: istore_3
    //   185: aload_1
    //   186: iload_3
    //   187: invokevirtual charAt : (I)C
    //   190: bipush #91
    //   192: if_icmpne -> 201
    //   195: iinc #3, 1
    //   198: goto -> 185
    //   201: aload_1
    //   202: iload_3
    //   203: invokevirtual charAt : (I)C
    //   206: tableswitch default -> 368, 66 -> 332, 67 -> 326, 68 -> 362, 69 -> 368, 70 -> 350, 71 -> 368, 72 -> 368, 73 -> 344, 74 -> 356, 75 -> 368, 76 -> 368, 77 -> 368, 78 -> 368, 79 -> 368, 80 -> 368, 81 -> 368, 82 -> 368, 83 -> 338, 84 -> 368, 85 -> 368, 86 -> 368, 87 -> 368, 88 -> 368, 89 -> 368, 90 -> 320
    //   320: ldc 16777225
    //   322: istore_0
    //   323: goto -> 391
    //   326: ldc 16777227
    //   328: istore_0
    //   329: goto -> 391
    //   332: ldc 16777226
    //   334: istore_0
    //   335: goto -> 391
    //   338: ldc 16777228
    //   340: istore_0
    //   341: goto -> 391
    //   344: ldc 16777217
    //   346: istore_0
    //   347: goto -> 391
    //   350: ldc 16777218
    //   352: istore_0
    //   353: goto -> 391
    //   356: ldc 16777220
    //   358: istore_0
    //   359: goto -> 391
    //   362: ldc 16777219
    //   364: istore_0
    //   365: goto -> 391
    //   368: aload_1
    //   369: iload_3
    //   370: iconst_1
    //   371: iadd
    //   372: aload_1
    //   373: invokevirtual length : ()I
    //   376: iconst_1
    //   377: isub
    //   378: invokevirtual substring : (II)Ljava/lang/String;
    //   381: astore_1
    //   382: ldc 24117248
    //   384: aload_0
    //   385: aload_1
    //   386: invokevirtual c : (Ljava/lang/String;)I
    //   389: ior
    //   390: istore_0
    //   391: iload_3
    //   392: iload_2
    //   393: isub
    //   394: bipush #28
    //   396: ishl
    //   397: iload_0
    //   398: ior
    //   399: ireturn
  }
  
  private int a() {
    return (this.g > 0) ? this.f[--this.g] : (0x3000000 | ---this.b.f);
  }
  
  private void c(int paramInt) {
    if (this.g >= paramInt) {
      this.g -= paramInt;
      return;
    } 
    this.b.f -= paramInt - this.g;
    this.g = 0;
  }
  
  private void a(String paramString) {
    char c;
    if ((c = paramString.charAt(0)) == '(') {
      c((Type.getArgumentsAndReturnSizes(paramString) >> 2) - 1);
      return;
    } 
    if (c == 'J' || c == 'D') {
      c(2);
      return;
    } 
    c(1);
  }
  
  private void d(int paramInt) {
    if (this.i == null)
      this.i = new int[2]; 
    int i = this.i.length;
    if (this.h >= i) {
      int[] arrayOfInt = new int[Math.max(this.h + 1, 2 * i)];
      System.arraycopy(this.i, 0, arrayOfInt, 0, i);
      this.i = arrayOfInt;
    } 
    this.i[this.h++] = paramInt;
  }
  
  private int a(ClassWriter paramClassWriter, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: ldc 16777222
    //   3: if_icmpne -> 21
    //   6: ldc 24117248
    //   8: aload_1
    //   9: dup
    //   10: getfield I : Ljava/lang/String;
    //   13: invokevirtual c : (Ljava/lang/String;)I
    //   16: ior
    //   17: istore_1
    //   18: goto -> 57
    //   21: iload_2
    //   22: ldc -1048576
    //   24: iand
    //   25: ldc 25165824
    //   27: if_icmpne -> 55
    //   30: aload_1
    //   31: getfield H : [Lcom/esotericsoftware/asm/Item;
    //   34: iload_2
    //   35: ldc 1048575
    //   37: iand
    //   38: aaload
    //   39: getfield g : Ljava/lang/String;
    //   42: astore_3
    //   43: ldc 24117248
    //   45: aload_1
    //   46: aload_3
    //   47: invokevirtual c : (Ljava/lang/String;)I
    //   50: ior
    //   51: istore_1
    //   52: goto -> 57
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_3
    //   59: iload_3
    //   60: aload_0
    //   61: getfield h : I
    //   64: if_icmpge -> 154
    //   67: aload_0
    //   68: getfield i : [I
    //   71: iload_3
    //   72: iaload
    //   73: dup
    //   74: istore #4
    //   76: ldc -268435456
    //   78: iand
    //   79: istore #5
    //   81: iload #4
    //   83: ldc 251658240
    //   85: iand
    //   86: dup
    //   87: istore #6
    //   89: ldc 33554432
    //   91: if_icmpne -> 112
    //   94: iload #5
    //   96: aload_0
    //   97: getfield c : [I
    //   100: iload #4
    //   102: ldc 8388607
    //   104: iand
    //   105: iaload
    //   106: iadd
    //   107: istore #4
    //   109: goto -> 140
    //   112: iload #6
    //   114: ldc 50331648
    //   116: if_icmpne -> 140
    //   119: iload #5
    //   121: aload_0
    //   122: getfield d : [I
    //   125: aload_0
    //   126: getfield d : [I
    //   129: arraylength
    //   130: iload #4
    //   132: ldc 8388607
    //   134: iand
    //   135: isub
    //   136: iaload
    //   137: iadd
    //   138: istore #4
    //   140: iload_2
    //   141: iload #4
    //   143: if_icmpne -> 148
    //   146: iload_1
    //   147: ireturn
    //   148: iinc #3, 1
    //   151: goto -> 59
    //   154: iload_2
    //   155: ireturn
  }
  
  final void a(ClassWriter paramClassWriter, int paramInt1, Type[] paramArrayOfType, int paramInt2) {
    this.c = new int[paramInt2];
    this.d = new int[0];
    byte b = 0;
    if ((paramInt1 & 0x8) == 0)
      if ((paramInt1 & 0x80000) == 0) {
        b++;
        this.c[0] = 0x1700000 | paramClassWriter.c(paramClassWriter.I);
      } else {
        b++;
        this.c[0] = 16777222;
      }  
    for (paramInt1 = 0; paramInt1 < paramArrayOfType.length; paramInt1++) {
      int i = b(paramClassWriter, paramArrayOfType[paramInt1].getDescriptor());
      this.c[b++] = i;
      if (i == 16777220 || i == 16777219)
        this.c[b++] = 16777216; 
    } 
    while (b < paramInt2)
      this.c[b++] = 16777216; 
  }
  
  final void a(int paramInt1, int paramInt2, ClassWriter paramClassWriter, Item paramItem) {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch default -> 2061, 0 -> 816, 1 -> 817, 2 -> 824, 3 -> 824, 4 -> 824, 5 -> 824, 6 -> 824, 7 -> 824, 8 -> 824, 9 -> 831, 10 -> 831, 11 -> 844, 12 -> 844, 13 -> 844, 14 -> 851, 15 -> 851, 16 -> 824, 17 -> 824, 18 -> 864, 19 -> 2061, 20 -> 2061, 21 -> 824, 22 -> 831, 23 -> 844, 24 -> 851, 25 -> 1036, 26 -> 2061, 27 -> 2061, 28 -> 2061, 29 -> 2061, 30 -> 2061, 31 -> 2061, 32 -> 2061, 33 -> 2061, 34 -> 2061, 35 -> 2061, 36 -> 2061, 37 -> 2061, 38 -> 2061, 39 -> 2061, 40 -> 2061, 41 -> 2061, 42 -> 2061, 43 -> 2061, 44 -> 2061, 45 -> 2061, 46 -> 1046, 47 -> 1058, 48 -> 1076, 49 -> 1088, 50 -> 1106, 51 -> 1046, 52 -> 1046, 53 -> 1046, 54 -> 1127, 55 -> 1195, 56 -> 1127, 57 -> 1195, 58 -> 1127, 59 -> 2061, 60 -> 2061, 61 -> 2061, 62 -> 2061, 63 -> 2061, 64 -> 2061, 65 -> 2061, 66 -> 2061, 67 -> 2061, 68 -> 2061, 69 -> 2061, 70 -> 2061, 71 -> 2061, 72 -> 2061, 73 -> 2061, 74 -> 2061, 75 -> 2061, 76 -> 2061, 77 -> 2061, 78 -> 2061, 79 -> 1277, 80 -> 1283, 81 -> 1277, 82 -> 1283, 83 -> 1277, 84 -> 1277, 85 -> 1277, 86 -> 1277, 87 -> 1289, 88 -> 1295, 89 -> 1301, 90 -> 1320, 91 -> 1349, 92 -> 1388, 93 -> 1422, 94 -> 1466, 95 -> 1520, 96 -> 1543, 97 -> 1555, 98 -> 1573, 99 -> 1585, 100 -> 1543, 101 -> 1555, 102 -> 1573, 103 -> 1585, 104 -> 1543, 105 -> 1555, 106 -> 1573, 107 -> 1585, 108 -> 1543, 109 -> 1555, 110 -> 1573, 111 -> 1585, 112 -> 1543, 113 -> 1555, 114 -> 1573, 115 -> 1585, 116 -> 816, 117 -> 816, 118 -> 816, 119 -> 816, 120 -> 1543, 121 -> 1603, 122 -> 1543, 123 -> 1603, 124 -> 1543, 125 -> 1603, 126 -> 1543, 127 -> 1555, 128 -> 1543, 129 -> 1555, 130 -> 1543, 131 -> 1555, 132 -> 1621, 133 -> 1629, 134 -> 1647, 135 -> 1659, 136 -> 1543, 137 -> 1573, 138 -> 1088, 139 -> 1677, 140 -> 1629, 141 -> 1659, 142 -> 1543, 143 -> 1058, 144 -> 1573, 145 -> 816, 146 -> 816, 147 -> 816, 148 -> 1689, 149 -> 1543, 150 -> 1543, 151 -> 1689, 152 -> 1689, 153 -> 1289, 154 -> 1289, 155 -> 1289, 156 -> 1289, 157 -> 1289, 158 -> 1289, 159 -> 1295, 160 -> 1295, 161 -> 1295, 162 -> 1295, 163 -> 1295, 164 -> 1295, 165 -> 1295, 166 -> 1295, 167 -> 816, 168 -> 1701, 169 -> 1701, 170 -> 1289, 171 -> 1289, 172 -> 1289, 173 -> 1295, 174 -> 1289, 175 -> 1295, 176 -> 1289, 177 -> 816, 178 -> 1711, 179 -> 1722, 180 -> 1732, 181 -> 1748, 182 -> 1763, 183 -> 1763, 184 -> 1763, 185 -> 1763, 186 -> 1823, 187 -> 1843, 188 -> 1861, 189 -> 1964, 190 -> 1677, 191 -> 1289, 192 -> 2020, 193 -> 1677, 194 -> 1289, 195 -> 1289, 196 -> 2061, 197 -> 2061, 198 -> 1289, 199 -> 1289
    //   816: return
    //   817: aload_0
    //   818: ldc 16777221
    //   820: invokespecial b : (I)V
    //   823: return
    //   824: aload_0
    //   825: ldc 16777217
    //   827: invokespecial b : (I)V
    //   830: return
    //   831: aload_0
    //   832: ldc 16777220
    //   834: invokespecial b : (I)V
    //   837: aload_0
    //   838: ldc 16777216
    //   840: invokespecial b : (I)V
    //   843: return
    //   844: aload_0
    //   845: ldc 16777218
    //   847: invokespecial b : (I)V
    //   850: return
    //   851: aload_0
    //   852: ldc 16777219
    //   854: invokespecial b : (I)V
    //   857: aload_0
    //   858: ldc 16777216
    //   860: invokespecial b : (I)V
    //   863: return
    //   864: aload #4
    //   866: getfield b : I
    //   869: tableswitch default -> 1022, 3 -> 940, 4 -> 960, 5 -> 947, 6 -> 967, 7 -> 980, 8 -> 994, 9 -> 1022, 10 -> 1022, 11 -> 1022, 12 -> 1022, 13 -> 1022, 14 -> 1022, 15 -> 1022, 16 -> 1008
    //   940: aload_0
    //   941: ldc 16777217
    //   943: invokespecial b : (I)V
    //   946: return
    //   947: aload_0
    //   948: ldc 16777220
    //   950: invokespecial b : (I)V
    //   953: aload_0
    //   954: ldc 16777216
    //   956: invokespecial b : (I)V
    //   959: return
    //   960: aload_0
    //   961: ldc 16777218
    //   963: invokespecial b : (I)V
    //   966: return
    //   967: aload_0
    //   968: ldc 16777219
    //   970: invokespecial b : (I)V
    //   973: aload_0
    //   974: ldc 16777216
    //   976: invokespecial b : (I)V
    //   979: return
    //   980: aload_0
    //   981: ldc 24117248
    //   983: aload_3
    //   984: ldc 'java/lang/Class'
    //   986: invokevirtual c : (Ljava/lang/String;)I
    //   989: ior
    //   990: invokespecial b : (I)V
    //   993: return
    //   994: aload_0
    //   995: ldc 24117248
    //   997: aload_3
    //   998: ldc 'java/lang/String'
    //   1000: invokevirtual c : (Ljava/lang/String;)I
    //   1003: ior
    //   1004: invokespecial b : (I)V
    //   1007: return
    //   1008: aload_0
    //   1009: ldc 24117248
    //   1011: aload_3
    //   1012: ldc 'java/lang/invoke/MethodType'
    //   1014: invokevirtual c : (Ljava/lang/String;)I
    //   1017: ior
    //   1018: invokespecial b : (I)V
    //   1021: return
    //   1022: aload_0
    //   1023: ldc 24117248
    //   1025: aload_3
    //   1026: ldc 'java/lang/invoke/MethodHandle'
    //   1028: invokevirtual c : (Ljava/lang/String;)I
    //   1031: ior
    //   1032: invokespecial b : (I)V
    //   1035: return
    //   1036: aload_0
    //   1037: dup
    //   1038: iload_2
    //   1039: invokespecial a : (I)I
    //   1042: invokespecial b : (I)V
    //   1045: return
    //   1046: aload_0
    //   1047: iconst_2
    //   1048: invokespecial c : (I)V
    //   1051: aload_0
    //   1052: ldc 16777217
    //   1054: invokespecial b : (I)V
    //   1057: return
    //   1058: aload_0
    //   1059: iconst_2
    //   1060: invokespecial c : (I)V
    //   1063: aload_0
    //   1064: ldc 16777220
    //   1066: invokespecial b : (I)V
    //   1069: aload_0
    //   1070: ldc 16777216
    //   1072: invokespecial b : (I)V
    //   1075: return
    //   1076: aload_0
    //   1077: iconst_2
    //   1078: invokespecial c : (I)V
    //   1081: aload_0
    //   1082: ldc 16777218
    //   1084: invokespecial b : (I)V
    //   1087: return
    //   1088: aload_0
    //   1089: iconst_2
    //   1090: invokespecial c : (I)V
    //   1093: aload_0
    //   1094: ldc 16777219
    //   1096: invokespecial b : (I)V
    //   1099: aload_0
    //   1100: ldc 16777216
    //   1102: invokespecial b : (I)V
    //   1105: return
    //   1106: aload_0
    //   1107: iconst_1
    //   1108: invokespecial c : (I)V
    //   1111: aload_0
    //   1112: invokespecial a : ()I
    //   1115: istore #5
    //   1117: aload_0
    //   1118: iload #5
    //   1120: ldc -268435456
    //   1122: iadd
    //   1123: invokespecial b : (I)V
    //   1126: return
    //   1127: aload_0
    //   1128: invokespecial a : ()I
    //   1131: istore #5
    //   1133: aload_0
    //   1134: iload_2
    //   1135: iload #5
    //   1137: invokespecial a : (II)V
    //   1140: iload_2
    //   1141: ifle -> 2076
    //   1144: aload_0
    //   1145: iload_2
    //   1146: iconst_1
    //   1147: isub
    //   1148: invokespecial a : (I)I
    //   1151: dup
    //   1152: istore_1
    //   1153: ldc 16777220
    //   1155: if_icmpeq -> 1164
    //   1158: iload_1
    //   1159: ldc 16777219
    //   1161: if_icmpne -> 1174
    //   1164: aload_0
    //   1165: iload_2
    //   1166: iconst_1
    //   1167: isub
    //   1168: ldc 16777216
    //   1170: invokespecial a : (II)V
    //   1173: return
    //   1174: iload_1
    //   1175: ldc 251658240
    //   1177: iand
    //   1178: ldc 16777216
    //   1180: if_icmpeq -> 2076
    //   1183: aload_0
    //   1184: iload_2
    //   1185: iconst_1
    //   1186: isub
    //   1187: iload_1
    //   1188: ldc 8388608
    //   1190: ior
    //   1191: invokespecial a : (II)V
    //   1194: return
    //   1195: aload_0
    //   1196: iconst_1
    //   1197: invokespecial c : (I)V
    //   1200: aload_0
    //   1201: invokespecial a : ()I
    //   1204: istore #5
    //   1206: aload_0
    //   1207: iload_2
    //   1208: iload #5
    //   1210: invokespecial a : (II)V
    //   1213: aload_0
    //   1214: iload_2
    //   1215: iconst_1
    //   1216: iadd
    //   1217: ldc 16777216
    //   1219: invokespecial a : (II)V
    //   1222: iload_2
    //   1223: ifle -> 2076
    //   1226: aload_0
    //   1227: iload_2
    //   1228: iconst_1
    //   1229: isub
    //   1230: invokespecial a : (I)I
    //   1233: dup
    //   1234: istore_1
    //   1235: ldc 16777220
    //   1237: if_icmpeq -> 1246
    //   1240: iload_1
    //   1241: ldc 16777219
    //   1243: if_icmpne -> 1256
    //   1246: aload_0
    //   1247: iload_2
    //   1248: iconst_1
    //   1249: isub
    //   1250: ldc 16777216
    //   1252: invokespecial a : (II)V
    //   1255: return
    //   1256: iload_1
    //   1257: ldc 251658240
    //   1259: iand
    //   1260: ldc 16777216
    //   1262: if_icmpeq -> 2076
    //   1265: aload_0
    //   1266: iload_2
    //   1267: iconst_1
    //   1268: isub
    //   1269: iload_1
    //   1270: ldc 8388608
    //   1272: ior
    //   1273: invokespecial a : (II)V
    //   1276: return
    //   1277: aload_0
    //   1278: iconst_3
    //   1279: invokespecial c : (I)V
    //   1282: return
    //   1283: aload_0
    //   1284: iconst_4
    //   1285: invokespecial c : (I)V
    //   1288: return
    //   1289: aload_0
    //   1290: iconst_1
    //   1291: invokespecial c : (I)V
    //   1294: return
    //   1295: aload_0
    //   1296: iconst_2
    //   1297: invokespecial c : (I)V
    //   1300: return
    //   1301: aload_0
    //   1302: invokespecial a : ()I
    //   1305: istore #5
    //   1307: aload_0
    //   1308: iload #5
    //   1310: invokespecial b : (I)V
    //   1313: aload_0
    //   1314: iload #5
    //   1316: invokespecial b : (I)V
    //   1319: return
    //   1320: aload_0
    //   1321: invokespecial a : ()I
    //   1324: istore #5
    //   1326: aload_0
    //   1327: invokespecial a : ()I
    //   1330: istore_1
    //   1331: aload_0
    //   1332: iload #5
    //   1334: invokespecial b : (I)V
    //   1337: aload_0
    //   1338: iload_1
    //   1339: invokespecial b : (I)V
    //   1342: aload_0
    //   1343: iload #5
    //   1345: invokespecial b : (I)V
    //   1348: return
    //   1349: aload_0
    //   1350: invokespecial a : ()I
    //   1353: istore #5
    //   1355: aload_0
    //   1356: invokespecial a : ()I
    //   1359: istore_1
    //   1360: aload_0
    //   1361: invokespecial a : ()I
    //   1364: istore_2
    //   1365: aload_0
    //   1366: iload #5
    //   1368: invokespecial b : (I)V
    //   1371: aload_0
    //   1372: iload_2
    //   1373: invokespecial b : (I)V
    //   1376: aload_0
    //   1377: iload_1
    //   1378: invokespecial b : (I)V
    //   1381: aload_0
    //   1382: iload #5
    //   1384: invokespecial b : (I)V
    //   1387: return
    //   1388: aload_0
    //   1389: invokespecial a : ()I
    //   1392: istore #5
    //   1394: aload_0
    //   1395: invokespecial a : ()I
    //   1398: istore_1
    //   1399: aload_0
    //   1400: iload_1
    //   1401: invokespecial b : (I)V
    //   1404: aload_0
    //   1405: iload #5
    //   1407: invokespecial b : (I)V
    //   1410: aload_0
    //   1411: iload_1
    //   1412: invokespecial b : (I)V
    //   1415: aload_0
    //   1416: iload #5
    //   1418: invokespecial b : (I)V
    //   1421: return
    //   1422: aload_0
    //   1423: invokespecial a : ()I
    //   1426: istore #5
    //   1428: aload_0
    //   1429: invokespecial a : ()I
    //   1432: istore_1
    //   1433: aload_0
    //   1434: invokespecial a : ()I
    //   1437: istore_2
    //   1438: aload_0
    //   1439: iload_1
    //   1440: invokespecial b : (I)V
    //   1443: aload_0
    //   1444: iload #5
    //   1446: invokespecial b : (I)V
    //   1449: aload_0
    //   1450: iload_2
    //   1451: invokespecial b : (I)V
    //   1454: aload_0
    //   1455: iload_1
    //   1456: invokespecial b : (I)V
    //   1459: aload_0
    //   1460: iload #5
    //   1462: invokespecial b : (I)V
    //   1465: return
    //   1466: aload_0
    //   1467: invokespecial a : ()I
    //   1470: istore #5
    //   1472: aload_0
    //   1473: invokespecial a : ()I
    //   1476: istore_1
    //   1477: aload_0
    //   1478: invokespecial a : ()I
    //   1481: istore_2
    //   1482: aload_0
    //   1483: invokespecial a : ()I
    //   1486: istore_3
    //   1487: aload_0
    //   1488: iload_1
    //   1489: invokespecial b : (I)V
    //   1492: aload_0
    //   1493: iload #5
    //   1495: invokespecial b : (I)V
    //   1498: aload_0
    //   1499: iload_3
    //   1500: invokespecial b : (I)V
    //   1503: aload_0
    //   1504: iload_2
    //   1505: invokespecial b : (I)V
    //   1508: aload_0
    //   1509: iload_1
    //   1510: invokespecial b : (I)V
    //   1513: aload_0
    //   1514: iload #5
    //   1516: invokespecial b : (I)V
    //   1519: return
    //   1520: aload_0
    //   1521: invokespecial a : ()I
    //   1524: istore #5
    //   1526: aload_0
    //   1527: invokespecial a : ()I
    //   1530: istore_1
    //   1531: aload_0
    //   1532: iload #5
    //   1534: invokespecial b : (I)V
    //   1537: aload_0
    //   1538: iload_1
    //   1539: invokespecial b : (I)V
    //   1542: return
    //   1543: aload_0
    //   1544: iconst_2
    //   1545: invokespecial c : (I)V
    //   1548: aload_0
    //   1549: ldc 16777217
    //   1551: invokespecial b : (I)V
    //   1554: return
    //   1555: aload_0
    //   1556: iconst_4
    //   1557: invokespecial c : (I)V
    //   1560: aload_0
    //   1561: ldc 16777220
    //   1563: invokespecial b : (I)V
    //   1566: aload_0
    //   1567: ldc 16777216
    //   1569: invokespecial b : (I)V
    //   1572: return
    //   1573: aload_0
    //   1574: iconst_2
    //   1575: invokespecial c : (I)V
    //   1578: aload_0
    //   1579: ldc 16777218
    //   1581: invokespecial b : (I)V
    //   1584: return
    //   1585: aload_0
    //   1586: iconst_4
    //   1587: invokespecial c : (I)V
    //   1590: aload_0
    //   1591: ldc 16777219
    //   1593: invokespecial b : (I)V
    //   1596: aload_0
    //   1597: ldc 16777216
    //   1599: invokespecial b : (I)V
    //   1602: return
    //   1603: aload_0
    //   1604: iconst_3
    //   1605: invokespecial c : (I)V
    //   1608: aload_0
    //   1609: ldc 16777220
    //   1611: invokespecial b : (I)V
    //   1614: aload_0
    //   1615: ldc 16777216
    //   1617: invokespecial b : (I)V
    //   1620: return
    //   1621: aload_0
    //   1622: iload_2
    //   1623: ldc 16777217
    //   1625: invokespecial a : (II)V
    //   1628: return
    //   1629: aload_0
    //   1630: iconst_1
    //   1631: invokespecial c : (I)V
    //   1634: aload_0
    //   1635: ldc 16777220
    //   1637: invokespecial b : (I)V
    //   1640: aload_0
    //   1641: ldc 16777216
    //   1643: invokespecial b : (I)V
    //   1646: return
    //   1647: aload_0
    //   1648: iconst_1
    //   1649: invokespecial c : (I)V
    //   1652: aload_0
    //   1653: ldc 16777218
    //   1655: invokespecial b : (I)V
    //   1658: return
    //   1659: aload_0
    //   1660: iconst_1
    //   1661: invokespecial c : (I)V
    //   1664: aload_0
    //   1665: ldc 16777219
    //   1667: invokespecial b : (I)V
    //   1670: aload_0
    //   1671: ldc 16777216
    //   1673: invokespecial b : (I)V
    //   1676: return
    //   1677: aload_0
    //   1678: iconst_1
    //   1679: invokespecial c : (I)V
    //   1682: aload_0
    //   1683: ldc 16777217
    //   1685: invokespecial b : (I)V
    //   1688: return
    //   1689: aload_0
    //   1690: iconst_4
    //   1691: invokespecial c : (I)V
    //   1694: aload_0
    //   1695: ldc 16777217
    //   1697: invokespecial b : (I)V
    //   1700: return
    //   1701: new java/lang/RuntimeException
    //   1704: dup
    //   1705: ldc 'JSR/RET are not supported with computeFrames option'
    //   1707: invokespecial <init> : (Ljava/lang/String;)V
    //   1710: athrow
    //   1711: aload_0
    //   1712: aload_3
    //   1713: aload #4
    //   1715: getfield i : Ljava/lang/String;
    //   1718: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   1721: return
    //   1722: aload_0
    //   1723: aload #4
    //   1725: getfield i : Ljava/lang/String;
    //   1728: invokespecial a : (Ljava/lang/String;)V
    //   1731: return
    //   1732: aload_0
    //   1733: iconst_1
    //   1734: invokespecial c : (I)V
    //   1737: aload_0
    //   1738: aload_3
    //   1739: aload #4
    //   1741: getfield i : Ljava/lang/String;
    //   1744: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   1747: return
    //   1748: aload_0
    //   1749: aload #4
    //   1751: getfield i : Ljava/lang/String;
    //   1754: invokespecial a : (Ljava/lang/String;)V
    //   1757: aload_0
    //   1758: invokespecial a : ()I
    //   1761: pop
    //   1762: return
    //   1763: aload_0
    //   1764: aload #4
    //   1766: getfield i : Ljava/lang/String;
    //   1769: invokespecial a : (Ljava/lang/String;)V
    //   1772: iload_1
    //   1773: sipush #184
    //   1776: if_icmpeq -> 1812
    //   1779: aload_0
    //   1780: invokespecial a : ()I
    //   1783: istore #5
    //   1785: iload_1
    //   1786: sipush #183
    //   1789: if_icmpne -> 1812
    //   1792: aload #4
    //   1794: getfield h : Ljava/lang/String;
    //   1797: iconst_0
    //   1798: invokevirtual charAt : (I)C
    //   1801: bipush #60
    //   1803: if_icmpne -> 1812
    //   1806: aload_0
    //   1807: iload #5
    //   1809: invokespecial d : (I)V
    //   1812: aload_0
    //   1813: aload_3
    //   1814: aload #4
    //   1816: getfield i : Ljava/lang/String;
    //   1819: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   1822: return
    //   1823: aload_0
    //   1824: aload #4
    //   1826: getfield h : Ljava/lang/String;
    //   1829: invokespecial a : (Ljava/lang/String;)V
    //   1832: aload_0
    //   1833: aload_3
    //   1834: aload #4
    //   1836: getfield h : Ljava/lang/String;
    //   1839: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   1842: return
    //   1843: aload_0
    //   1844: ldc 25165824
    //   1846: aload_3
    //   1847: aload #4
    //   1849: getfield g : Ljava/lang/String;
    //   1852: iload_2
    //   1853: invokevirtual a : (Ljava/lang/String;I)I
    //   1856: ior
    //   1857: invokespecial b : (I)V
    //   1860: return
    //   1861: aload_0
    //   1862: invokespecial a : ()I
    //   1865: pop
    //   1866: iload_2
    //   1867: tableswitch default -> 1957, 4 -> 1908, 5 -> 1915, 6 -> 1943, 7 -> 1950, 8 -> 1922, 9 -> 1929, 10 -> 1936
    //   1908: aload_0
    //   1909: ldc 285212681
    //   1911: invokespecial b : (I)V
    //   1914: return
    //   1915: aload_0
    //   1916: ldc 285212683
    //   1918: invokespecial b : (I)V
    //   1921: return
    //   1922: aload_0
    //   1923: ldc 285212682
    //   1925: invokespecial b : (I)V
    //   1928: return
    //   1929: aload_0
    //   1930: ldc 285212684
    //   1932: invokespecial b : (I)V
    //   1935: return
    //   1936: aload_0
    //   1937: ldc 285212673
    //   1939: invokespecial b : (I)V
    //   1942: return
    //   1943: aload_0
    //   1944: ldc 285212674
    //   1946: invokespecial b : (I)V
    //   1949: return
    //   1950: aload_0
    //   1951: ldc 285212675
    //   1953: invokespecial b : (I)V
    //   1956: return
    //   1957: aload_0
    //   1958: ldc 285212676
    //   1960: invokespecial b : (I)V
    //   1963: return
    //   1964: aload #4
    //   1966: getfield g : Ljava/lang/String;
    //   1969: astore_1
    //   1970: aload_0
    //   1971: invokespecial a : ()I
    //   1974: pop
    //   1975: aload_1
    //   1976: iconst_0
    //   1977: invokevirtual charAt : (I)C
    //   1980: bipush #91
    //   1982: if_icmpne -> 2007
    //   1985: aload_0
    //   1986: aload_3
    //   1987: new java/lang/StringBuffer
    //   1990: dup
    //   1991: ldc '['
    //   1993: invokespecial <init> : (Ljava/lang/String;)V
    //   1996: aload_1
    //   1997: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2000: invokevirtual toString : ()Ljava/lang/String;
    //   2003: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   2006: return
    //   2007: aload_0
    //   2008: ldc 292552704
    //   2010: aload_3
    //   2011: aload_1
    //   2012: invokevirtual c : (Ljava/lang/String;)I
    //   2015: ior
    //   2016: invokespecial b : (I)V
    //   2019: return
    //   2020: aload #4
    //   2022: getfield g : Ljava/lang/String;
    //   2025: astore_1
    //   2026: aload_0
    //   2027: invokespecial a : ()I
    //   2030: pop
    //   2031: aload_1
    //   2032: iconst_0
    //   2033: invokevirtual charAt : (I)C
    //   2036: bipush #91
    //   2038: if_icmpne -> 2048
    //   2041: aload_0
    //   2042: aload_3
    //   2043: aload_1
    //   2044: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   2047: return
    //   2048: aload_0
    //   2049: ldc 24117248
    //   2051: aload_3
    //   2052: aload_1
    //   2053: invokevirtual c : (Ljava/lang/String;)I
    //   2056: ior
    //   2057: invokespecial b : (I)V
    //   2060: return
    //   2061: aload_0
    //   2062: iload_2
    //   2063: invokespecial c : (I)V
    //   2066: aload_0
    //   2067: aload_3
    //   2068: aload #4
    //   2070: getfield g : Ljava/lang/String;
    //   2073: invokespecial a : (Lcom/esotericsoftware/asm/ClassWriter;Ljava/lang/String;)V
    //   2076: return
  }
  
  final boolean a(ClassWriter paramClassWriter, Frame paramFrame, int paramInt) {
    boolean bool = false;
    int i = this.c.length;
    int j = this.d.length;
    if (paramFrame.c == null) {
      paramFrame.c = new int[i];
      bool = true;
    } 
    byte b;
    for (b = 0; b < i; b++) {
      int m;
      int k;
      if (this.e != null && b < this.e.length && (k = this.e[b]) != 0) {
        m = k & 0xF0000000;
        int n;
        if ((n = k & 0xF000000) == 16777216) {
          m = k;
        } else {
          if (n == 33554432) {
            m += this.c[k & 0x7FFFFF];
          } else {
            m += this.d[j - (k & 0x7FFFFF)];
          } 
          if ((k & 0x800000) != 0 && (m == 16777220 || m == 16777219))
            m = 16777216; 
        } 
      } else {
        m = this.c[b];
      } 
      if (this.i != null)
        m = a(paramClassWriter, m); 
      bool |= a(paramClassWriter, m, paramFrame.c, b);
    } 
    if (paramInt > 0) {
      for (b = 0; b < i; b++) {
        int k = this.c[b];
        bool |= a(paramClassWriter, k, paramFrame.c, b);
      } 
      if (paramFrame.d == null) {
        paramFrame.d = new int[1];
        bool = true;
      } 
      return bool |= a(paramClassWriter, paramInt, paramFrame.d, 0);
    } 
    paramInt = this.d.length + this.b.f;
    if (paramFrame.d == null) {
      paramFrame.d = new int[paramInt + this.g];
      bool = true;
    } 
    for (b = 0; b < paramInt; b++) {
      int k = this.d[b];
      if (this.i != null)
        k = a(paramClassWriter, k); 
      bool |= a(paramClassWriter, k, paramFrame.d, b);
    } 
    for (b = 0; b < this.g; b++) {
      int k;
      int m = (k = this.f[b]) & 0xF0000000;
      int n;
      if ((n = k & 0xF000000) == 16777216) {
        m = k;
      } else {
        if (n == 33554432) {
          m += this.c[k & 0x7FFFFF];
        } else {
          m += this.d[j - (k & 0x7FFFFF)];
        } 
        if ((k & 0x800000) != 0 && (m == 16777220 || m == 16777219))
          m = 16777216; 
      } 
      if (this.i != null)
        m = a(paramClassWriter, m); 
      bool |= a(paramClassWriter, m, paramFrame.d, paramInt + b);
    } 
    return bool;
  }
  
  private static boolean a(ClassWriter paramClassWriter, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    // Byte code:
    //   0: aload_2
    //   1: iload_3
    //   2: iaload
    //   3: dup
    //   4: istore #4
    //   6: iload_1
    //   7: if_icmpne -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: iload_1
    //   13: ldc 268435455
    //   15: iand
    //   16: ldc 16777221
    //   18: if_icmpne -> 33
    //   21: iload #4
    //   23: ldc 16777221
    //   25: if_icmpne -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: ldc 16777221
    //   32: istore_1
    //   33: iload #4
    //   35: ifne -> 44
    //   38: aload_2
    //   39: iload_3
    //   40: iload_1
    //   41: iastore
    //   42: iconst_1
    //   43: ireturn
    //   44: iload #4
    //   46: ldc 267386880
    //   48: iand
    //   49: ldc 24117248
    //   51: if_icmpeq -> 62
    //   54: iload #4
    //   56: ldc -268435456
    //   58: iand
    //   59: ifeq -> 243
    //   62: iload_1
    //   63: ldc 16777221
    //   65: if_icmpne -> 70
    //   68: iconst_0
    //   69: ireturn
    //   70: iload_1
    //   71: ldc -1048576
    //   73: iand
    //   74: iload #4
    //   76: ldc -1048576
    //   78: iand
    //   79: if_icmpne -> 141
    //   82: iload #4
    //   84: ldc 267386880
    //   86: iand
    //   87: ldc 24117248
    //   89: if_icmpne -> 117
    //   92: iload_1
    //   93: ldc -268435456
    //   95: iand
    //   96: ldc 24117248
    //   98: ior
    //   99: aload_0
    //   100: iload_1
    //   101: ldc 1048575
    //   103: iand
    //   104: iload #4
    //   106: ldc 1048575
    //   108: iand
    //   109: invokevirtual a : (II)I
    //   112: ior
    //   113: istore_0
    //   114: goto -> 279
    //   117: ldc -268435456
    //   119: iload #4
    //   121: ldc -268435456
    //   123: iand
    //   124: iadd
    //   125: dup
    //   126: istore_1
    //   127: ldc 24117248
    //   129: ior
    //   130: aload_0
    //   131: ldc 'java/lang/Object'
    //   133: invokevirtual c : (Ljava/lang/String;)I
    //   136: ior
    //   137: istore_0
    //   138: goto -> 279
    //   141: iload_1
    //   142: ldc 267386880
    //   144: iand
    //   145: ldc 24117248
    //   147: if_icmpeq -> 157
    //   150: iload_1
    //   151: ldc -268435456
    //   153: iand
    //   154: ifeq -> 237
    //   157: iload_1
    //   158: ldc -268435456
    //   160: iand
    //   161: ifeq -> 173
    //   164: iload_1
    //   165: ldc 267386880
    //   167: iand
    //   168: ldc 24117248
    //   170: if_icmpne -> 177
    //   173: iconst_0
    //   174: goto -> 179
    //   177: ldc -268435456
    //   179: iload_1
    //   180: ldc -268435456
    //   182: iand
    //   183: iadd
    //   184: istore_1
    //   185: iload #4
    //   187: ldc -268435456
    //   189: iand
    //   190: ifeq -> 203
    //   193: iload #4
    //   195: ldc 267386880
    //   197: iand
    //   198: ldc 24117248
    //   200: if_icmpne -> 207
    //   203: iconst_0
    //   204: goto -> 209
    //   207: ldc -268435456
    //   209: iload #4
    //   211: ldc -268435456
    //   213: iand
    //   214: iadd
    //   215: istore #5
    //   217: iload_1
    //   218: iload #5
    //   220: invokestatic min : (II)I
    //   223: ldc 24117248
    //   225: ior
    //   226: aload_0
    //   227: ldc 'java/lang/Object'
    //   229: invokevirtual c : (Ljava/lang/String;)I
    //   232: ior
    //   233: istore_0
    //   234: goto -> 279
    //   237: ldc 16777216
    //   239: istore_0
    //   240: goto -> 279
    //   243: iload #4
    //   245: ldc 16777221
    //   247: if_icmpne -> 276
    //   250: iload_1
    //   251: ldc 267386880
    //   253: iand
    //   254: ldc 24117248
    //   256: if_icmpeq -> 266
    //   259: iload_1
    //   260: ldc -268435456
    //   262: iand
    //   263: ifeq -> 270
    //   266: iload_1
    //   267: goto -> 272
    //   270: ldc 16777216
    //   272: istore_0
    //   273: goto -> 279
    //   276: ldc 16777216
    //   278: istore_0
    //   279: iload #4
    //   281: iload_0
    //   282: if_icmpeq -> 291
    //   285: aload_2
    //   286: iload_3
    //   287: iload_0
    //   288: iastore
    //   289: iconst_1
    //   290: ireturn
    //   291: iconst_0
    //   292: ireturn
  }
  
  static {
    _clinit_();
    int[] arrayOfInt = new int[202];
    String str = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
    for (byte b = 0; b < 'Ê'; b++)
      arrayOfInt[b] = str.charAt(b) - 69; 
    a = arrayOfInt;
  }
  
  static void _clinit_() {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Frame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */