/*     */ package com.d.c.d.a;
/*     */ 
/*     */ import com.d.c.a.c;
/*     */ import com.d.c.d.h;
/*     */ import com.d.c.d.j;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class f
/*     */ {
/*  32 */   private static final Map a = new HashMap<>();
/*  33 */   private static final Map b = new HashMap<>();
/*  34 */   private static final Map c = new HashMap<>();
/*     */   
/*     */   static {
/*  37 */     a.put("cyan", new h(65535));
/*  38 */     a.put("magenta", new h(16711935));
/*  39 */     a.put("black", new h(0));
/*  40 */     a.put("gray", new h(8421504));
/*  41 */     a.put("grey", new h(8421504));
/*  42 */     a.put("maroon", new h(8388608));
/*  43 */     a.put("red", new h(16711680));
/*  44 */     a.put("green", new h(32768));
/*  45 */     a.put("lime", new h(65280));
/*  46 */     a.put("olive", new h(8421376));
/*  47 */     a.put("yellow", new h(16776960));
/*  48 */     a.put("navy", new h(128));
/*  49 */     a.put("blue", new h(255));
/*  50 */     a.put("purple", new h(8388736));
/*  51 */     a.put("fuchsia", new h(16711935));
/*  52 */     a.put("teal", new h(32896));
/*  53 */     a.put("aqua", new h(65535));
/*  54 */     a.put("silver", new h(12632256));
/*  55 */     a.put("white", new h(16777215));
/*  56 */     a.put("aliceblue", new h(15792383));
/*  57 */     a.put("antiquewhite", new h(16444375));
/*  58 */     a.put("aquamarine", new h(8388564));
/*  59 */     a.put("azure", new h(15794175));
/*  60 */     a.put("beige", new h(16119260));
/*  61 */     a.put("blueviolet", new h(9055202));
/*  62 */     a.put("brown", new h(10824234));
/*  63 */     a.put("burlywood", new h(14596231));
/*  64 */     a.put("cadetblue", new h(6266528));
/*  65 */     a.put("chartreuse", new h(8388352));
/*  66 */     a.put("chocolate", new h(13789470));
/*  67 */     a.put("coral", new h(16744272));
/*  68 */     a.put("cornflowerblue", new h(6591981));
/*  69 */     a.put("cornsilk", new h(16775388));
/*  70 */     a.put("crimson", new h(14423100));
/*  71 */     a.put("darkblue", new h(139));
/*  72 */     a.put("darkcyan", new h(35723));
/*  73 */     a.put("darkgoldenrod", new h(12092939));
/*  74 */     a.put("darkgray", new h(11119017));
/*  75 */     a.put("darkgreen", new h(25600));
/*  76 */     a.put("darkkhaki", new h(12433259));
/*  77 */     a.put("darkmagenta", new h(9109643));
/*  78 */     a.put("darkolivegreen", new h(5597999));
/*  79 */     a.put("darkorange", new h(16747520));
/*  80 */     a.put("darkorchid", new h(10040012));
/*  81 */     a.put("darkred", new h(9109504));
/*  82 */     a.put("darksalmon", new h(15308410));
/*  83 */     a.put("darkseagreen", new h(9419919));
/*  84 */     a.put("darkslateblue", new h(4734347));
/*  85 */     a.put("darkslategray", new h(3100495));
/*  86 */     a.put("darkturquoise", new h(52945));
/*  87 */     a.put("darkviolet", new h(9699539));
/*  88 */     a.put("deeppink", new h(16716947));
/*  89 */     a.put("deepskyblue", new h(49151));
/*  90 */     a.put("dimgray", new h(6908265));
/*  91 */     a.put("dodgerblue", new h(2003199));
/*  92 */     a.put("firebrick", new h(11674146));
/*  93 */     a.put("floralwhite", new h(16775920));
/*  94 */     a.put("forestgreen", new h(2263842));
/*  95 */     a.put("gainsboro", new h(14474460));
/*  96 */     a.put("ghostwhite", new h(16316671));
/*  97 */     a.put("gold", new h(16766720));
/*  98 */     a.put("goldenrod", new h(14329120));
/*  99 */     a.put("greenyellow", new h(11403055));
/* 100 */     a.put("honeydew", new h(15794160));
/* 101 */     a.put("hotpink", new h(16738740));
/* 102 */     a.put("indianred", new h(13458524));
/* 103 */     a.put("indigo", new h(4915330));
/* 104 */     a.put("ivory", new h(16777200));
/* 105 */     a.put("khaki", new h(15787660));
/* 106 */     a.put("lavender", new h(15132410));
/* 107 */     a.put("lavenderblush", new h(16773365));
/* 108 */     a.put("lawngreen", new h(8190976));
/* 109 */     a.put("lemonchiffon", new h(16775885));
/* 110 */     a.put("lightblue", new h(11393254));
/* 111 */     a.put("lightcoral", new h(15761536));
/* 112 */     a.put("lightcyan", new h(14745599));
/* 113 */     a.put("lightgoldenrodyellow", new h(16448210));
/* 114 */     a.put("lightgreen", new h(9498256));
/* 115 */     a.put("lightgrey", new h(13882323));
/* 116 */     a.put("lightpink", new h(16758465));
/* 117 */     a.put("lightsalmon", new h(16752762));
/* 118 */     a.put("lightseagreen", new h(2142890));
/* 119 */     a.put("lightskyblue", new h(8900346));
/* 120 */     a.put("lightslategray", new h(7833753));
/* 121 */     a.put("lightsteelblue", new h(11584734));
/* 122 */     a.put("lightyellow", new h(16777184));
/* 123 */     a.put("limegreen", new h(3329330));
/* 124 */     a.put("linen", new h(16445670));
/* 125 */     a.put("mediumaquamarine", new h(6737322));
/* 126 */     a.put("mediumblue", new h(205));
/* 127 */     a.put("mediumorchid", new h(12211667));
/* 128 */     a.put("mediumpurple", new h(9662683));
/* 129 */     a.put("mediumseagreen", new h(3978097));
/* 130 */     a.put("mediumslateblue", new h(8087790));
/* 131 */     a.put("mediumspringgreen", new h(64154));
/* 132 */     a.put("mediumturquoise", new h(4772300));
/* 133 */     a.put("mediumvioletred", new h(13047173));
/* 134 */     a.put("midnightblue", new h(1644912));
/* 135 */     a.put("mintcream", new h(16121850));
/* 136 */     a.put("mistyrose", new h(16770273));
/* 137 */     a.put("moccasin", new h(16770229));
/* 138 */     a.put("navajowhite", new h(16768685));
/* 139 */     a.put("oldlace", new h(16643558));
/* 140 */     a.put("olivedrab", new h(7048739));
/* 141 */     a.put("orange", new h(16753920));
/* 142 */     a.put("orangered", new h(16729344));
/* 143 */     a.put("orchid", new h(14315734));
/* 144 */     a.put("palegoldenrod", new h(15657130));
/* 145 */     a.put("palegreen", new h(10025880));
/* 146 */     a.put("paleturquoise", new h(11529966));
/* 147 */     a.put("palevioletred", new h(14381203));
/* 148 */     a.put("papayawhip", new h(16773077));
/* 149 */     a.put("peachpuff", new h(16767673));
/* 150 */     a.put("peru", new h(13468991));
/* 151 */     a.put("pink", new h(16761035));
/* 152 */     a.put("plum", new h(14524637));
/* 153 */     a.put("powderblue", new h(11591910));
/* 154 */     a.put("rosybrown", new h(12357519));
/* 155 */     a.put("royalblue", new h(4286945));
/* 156 */     a.put("saddlebrown", new h(9127187));
/* 157 */     a.put("salmon", new h(16416882));
/* 158 */     a.put("sandybrown", new h(16032864));
/* 159 */     a.put("seagreen", new h(3050327));
/* 160 */     a.put("seashell", new h(16774638));
/* 161 */     a.put("sienna", new h(10506797));
/* 162 */     a.put("skyblue", new h(8900331));
/* 163 */     a.put("slateblue", new h(6970061));
/* 164 */     a.put("slategray", new h(7372944));
/* 165 */     a.put("snow", new h(16775930));
/* 166 */     a.put("springgreen", new h(65407));
/* 167 */     a.put("steelblue", new h(4620980));
/* 168 */     a.put("tan", new h(13808780));
/* 169 */     a.put("thistle", new h(14204888));
/* 170 */     a.put("tomato", new h(16737095));
/* 171 */     a.put("turquoise", new h(4251856));
/* 172 */     a.put("violet", new h(976942));
/* 173 */     a.put("wheat", new h(16113331));
/* 174 */     a.put("whitesmoke", new h(16119285));
/* 175 */     a.put("yellowgreen", new h(10145074));
/*     */ 
/*     */ 
/*     */     
/* 179 */     b.put(Float.valueOf(100.0F), c.C);
/* 180 */     b.put(Float.valueOf(200.0F), c.D);
/* 181 */     b.put(Float.valueOf(300.0F), c.E);
/* 182 */     b.put(Float.valueOf(400.0F), c.F);
/* 183 */     b.put(Float.valueOf(500.0F), c.G);
/* 184 */     b.put(Float.valueOf(600.0F), c.H);
/* 185 */     b.put(Float.valueOf(700.0F), c.I);
/* 186 */     b.put(Float.valueOf(800.0F), c.J);
/* 187 */     b.put(Float.valueOf(900.0F), c.K);
/*     */ 
/*     */ 
/*     */     
/* 191 */     c.put("thin", new j((short)5, 1.0F, "1px"));
/* 192 */     c.put("medium", new j((short)5, 2.0F, "2px"));
/* 193 */     c.put("thick", new j((short)5, 3.0F, "3px"));
/*     */   }
/*     */   
/*     */   public static h a(String paramString) {
/* 197 */     return (h)a.get(paramString);
/*     */   }
/*     */   
/*     */   public static c a(float paramFloat) {
/* 201 */     return (c)b.get(Float.valueOf(paramFloat));
/*     */   }
/*     */   
/*     */   public static j b(String paramString) {
/* 205 */     return (j)c.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */