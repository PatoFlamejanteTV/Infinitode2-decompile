/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ public class MaterialColor {
/*     */   public static final int BYTE_PALETTE_COLOR_COUNT = 18;
/*     */   public static final int BYTE_PALETTE_VARIANT_COUNT = 5;
/*     */   
/*   7 */   public enum Variants { P50,
/*   8 */     P100,
/*   9 */     P200,
/*  10 */     P300,
/*  11 */     P400,
/*  12 */     P500,
/*  13 */     P600,
/*  14 */     P700,
/*  15 */     P800,
/*  16 */     P900,
/*     */     
/*  18 */     A100,
/*  19 */     A200,
/*  20 */     A400,
/*  21 */     A700; static {
/*     */     
/*  23 */     } public static final Variants[] values = values(); }
/*     */ 
/*     */   
/*     */   public enum Colors {
/*  27 */     RED,
/*  28 */     PINK,
/*  29 */     PURPLE,
/*  30 */     DEEP_PURPLE,
/*  31 */     INDIGO,
/*  32 */     BLUE,
/*  33 */     LIGHT_BLUE,
/*  34 */     CYAN,
/*  35 */     TEAL,
/*  36 */     GREEN,
/*  37 */     LIGHT_GREEN,
/*  38 */     LIME,
/*  39 */     YELLOW,
/*  40 */     AMBER,
/*  41 */     ORANGE,
/*  42 */     DEEP_ORANGE,
/*  43 */     BROWN,
/*  44 */     GREY,
/*  45 */     BLUE_GREY;
/*     */     
/*  47 */     public static final Colors[] values = values();
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*  53 */   public static final Color[] BYTE_PALETTE = new Color[] { RED.P200, RED.P300, RED.P500, RED.P700, RED.P900, PINK.P200, PINK.P300, PINK.P500, PINK.P700, PINK.P900, PURPLE.P200, PURPLE.P300, PURPLE.P500, PURPLE.P700, PURPLE.P900, DEEP_PURPLE.P200, DEEP_PURPLE.P300, DEEP_PURPLE.P500, DEEP_PURPLE.P700, DEEP_PURPLE.P900, INDIGO.P200, INDIGO.P300, INDIGO.P500, INDIGO.P700, INDIGO.P900, BLUE.P200, BLUE.P300, BLUE.P500, BLUE.P700, BLUE.P900, CYAN.P200, CYAN.P300, CYAN.P500, CYAN.P700, CYAN.P900, TEAL.P200, TEAL.P300, TEAL.P500, TEAL.P700, TEAL.P900, GREEN.P200, GREEN.P300, GREEN.P500, GREEN.P700, GREEN.P900, LIGHT_GREEN.P200, LIGHT_GREEN.P300, LIGHT_GREEN.P500, LIGHT_GREEN.P700, LIGHT_GREEN.P900, LIME.P200, LIME.P300, LIME.P500, LIME.P700, LIME.P900, YELLOW.P200, YELLOW.P300, YELLOW.P500, YELLOW.P700, YELLOW.P900, AMBER.P200, AMBER.P300, AMBER.P500, AMBER.P700, AMBER.P900, ORANGE.P200, ORANGE.P300, ORANGE.P500, ORANGE.P700, ORANGE.P900, DEEP_ORANGE.P200, DEEP_ORANGE.P300, DEEP_ORANGE.P500, DEEP_ORANGE.P700, DEEP_ORANGE.P900, BROWN.P200, BROWN.P300, BROWN.P500, BROWN.P700, BROWN.P900, GREY.P200, GREY.P300, GREY.P500, GREY.P700, GREY.P900, BLUE_GREY.P200, BLUE_GREY.P300, BLUE_GREY.P500, BLUE_GREY.P700, BLUE_GREY.P900, Color.BLACK, Color.WHITE };
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
/*     */   public static class RED
/*     */   {
/*  77 */     public static final Color P50 = new Color(-1315073);
/*  78 */     public static final Color P100 = new Color(-3288321);
/*  79 */     public static final Color P200 = new Color(-275080449);
/*  80 */     public static final Color P300 = new Color(-445418497);
/*  81 */     public static final Color P400 = new Color(-279752449);
/*  82 */     public static final Color P500 = new Color(-196921601);
/*  83 */     public static final Color P600 = new Color(-449235457);
/*  84 */     public static final Color P700 = new Color(-751882241);
/*  85 */     public static final Color P800 = new Color(-970446593);
/*  86 */     public static final Color P900 = new Color(-1222894337);
/*  87 */     public static final Color A100 = new Color(-7700225);
/*  88 */     public static final Color A200 = new Color(-11382017);
/*  89 */     public static final Color A400 = new Color(-15252225);
/*  90 */     public static final Color A700 = new Color(-721420033);
/*  91 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class PINK {
/*  95 */     public static final Color P50 = new Color(-52105985);
/*  96 */     public static final Color P100 = new Color(-121908993);
/*  97 */     public static final Color P200 = new Color(-191909377);
/*  98 */     public static final Color P300 = new Color(-261975297);
/*  99 */     public static final Color P400 = new Color(-331318529);
/* 100 */     public static final Color P500 = new Color(-383884289);
/* 101 */     public static final Color P600 = new Color(-669294337);
/* 102 */     public static final Color P700 = new Color(-1038590977);
/* 103 */     public static final Color P800 = new Color(-1391175681);
/* 104 */     public static final Color P900 = new Color(-2012327937);
/* 105 */     public static final Color A100 = new Color(-8344577);
/* 106 */     public static final Color A200 = new Color(-12549633);
/* 107 */     public static final Color A400 = new Color(-184526849);
/* 108 */     public static final Color A700 = new Color(-988716289);
/* 109 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class PURPLE {
/* 113 */     public static final Color P50 = new Color(-203033089);
/* 114 */     public static final Color P100 = new Color(-507582465);
/* 115 */     public static final Color P200 = new Color(-829171457);
/* 116 */     public static final Color P300 = new Color(-1167537921);
/* 117 */     public static final Color P400 = new Color(-1421361921);
/* 118 */     public static final Color P500 = new Color(-1675120385);
/* 119 */     public static final Color P600 = new Color(-1910199553);
/* 120 */     public static final Color P700 = new Color(2065670911);
/* 121 */     public static final Color P800 = new Color(1780194047);
/* 122 */     public static final Color P900 = new Color(1242860799);
/* 123 */     public static final Color A100 = new Color(-360645377);
/* 124 */     public static final Color A200 = new Color(-532612097);
/* 125 */     public static final Color A400 = new Color(-721356289);
/* 126 */     public static final Color A700 = new Color(-1442775041);
/* 127 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class DEEP_PURPLE {
/* 131 */     public static final Color P50 = new Color(-303565057);
/* 132 */     public static final Color P100 = new Color(-775624193);
/* 133 */     public static final Color P200 = new Color(-1281500161);
/* 134 */     public static final Color P300 = new Color(-1787441665);
/* 135 */     public static final Color P400 = new Color(2119680767);
/* 136 */     public static final Color P500 = new Color(1731901439);
/* 137 */     public static final Color P600 = new Color(1580577279);
/* 138 */     public static final Color P700 = new Color(1361946879);
/* 139 */     public static final Color P800 = new Color(1160225023);
/* 140 */     public static final Color P900 = new Color(823890687);
/* 141 */     public static final Color A100 = new Color(-1282867201);
/* 142 */     public static final Color A200 = new Color(2085486591);
/* 143 */     public static final Color A400 = new Color(1696595967);
/* 144 */     public static final Color A700 = new Color(1644227327);
/* 145 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class INDIGO {
/* 149 */     public static final Color P50 = new Color(-387254529);
/* 150 */     public static final Color P100 = new Color(-976557569);
/* 151 */     public static final Color P200 = new Color(-1616323841);
/* 152 */     public static final Color P300 = new Color(2038877183);
/* 153 */     public static final Color P400 = new Color(1550565631);
/* 154 */     public static final Color P500 = new Color(1062319615);
/* 155 */     public static final Color P600 = new Color(961129471);
/* 156 */     public static final Color P700 = new Color(809476095);
/* 157 */     public static final Color P800 = new Color(674599935);
/* 158 */     public static final Color P900 = new Color(438533887);
/* 159 */     public static final Color A100 = new Color(-1935736833);
/* 160 */     public static final Color A200 = new Color(1399717631);
/* 161 */     public static final Color A400 = new Color(1029373695);
/* 162 */     public static final Color A700 = new Color(810548991);
/* 163 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class BLUE {
/* 167 */     public static final Color P50 = new Color(-470614529);
/* 168 */     public static final Color P100 = new Color(-1143014401);
/* 169 */     public static final Color P200 = new Color(-1865745921);
/* 170 */     public static final Color P300 = new Color(1689646847);
/* 171 */     public static final Color P400 = new Color(1118172671);
/* 172 */     public static final Color P500 = new Color(563540991);
/* 173 */     public static final Color P600 = new Color(512288255);
/* 174 */     public static final Color P700 = new Color(427217663);
/* 175 */     public static final Color P800 = new Color(358990079);
/* 176 */     public static final Color P900 = new Color(222798335);
/* 177 */     public static final Color A100 = new Color(-2102263809);
/* 178 */     public static final Color A200 = new Color(1149960191);
/* 179 */     public static final Color A400 = new Color(695861247);
/* 180 */     public static final Color A700 = new Color(694353919);
/* 181 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class LIGHT_BLUE {
/* 185 */     public static final Color P50 = new Color(-503972097);
/* 186 */     public static final Color P100 = new Color(-1276773121);
/* 187 */     public static final Color P200 = new Color(-2116748545);
/* 188 */     public static final Color P300 = new Color(1338243071);
/* 189 */     public static final Color P400 = new Color(699856639);
/* 190 */     public static final Color P500 = new Color(61469951);
/* 191 */     public static final Color P600 = new Color(60548607);
/* 192 */     public static final Color P700 = new Color(42521087);
/* 193 */     public static final Color P800 = new Color(41401855);
/* 194 */     public static final Color P900 = new Color(22518783);
/* 195 */     public static final Color A100 = new Color(-2133262337);
/* 196 */     public static final Color A200 = new Color(1086652415);
/* 197 */     public static final Color A400 = new Color(11599871);
/* 198 */     public static final Color A700 = new Color(9562879);
/* 199 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class CYAN {
/* 203 */     public static final Color P50 = new Color(-520619265);
/* 204 */     public static final Color P100 = new Color(-1293159681);
/* 205 */     public static final Color P200 = new Color(-2132874497);
/* 206 */     public static final Color P300 = new Color(1305534975);
/* 207 */     public static final Color P400 = new Color(650566399);
/* 208 */     public static final Color P500 = new Color(12375295);
/* 209 */     public static final Color P600 = new Color(11321855);
/* 210 */     public static final Color P700 = new Color(9938943);
/* 211 */     public static final Color P800 = new Color(8622079);
/* 212 */     public static final Color P900 = new Color(6317311);
/* 213 */     public static final Color A100 = new Color(-2063597569);
/* 214 */     public static final Color A200 = new Color(419430399);
/* 215 */     public static final Color A400 = new Color(15073279);
/* 216 */     public static final Color A700 = new Color(12113151);
/* 217 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class TEAL {
/* 221 */     public static final Color P50 = new Color(-520949249);
/* 222 */     public static final Color P100 = new Color(-1293952001);
/* 223 */     public static final Color P200 = new Color(-2134129409);
/* 224 */     public static final Color P300 = new Color(1303817471);
/* 225 */     public static final Color P400 = new Color(648452863);
/* 226 */     public static final Color P500 = new Color(9865471);
/* 227 */     public static final Color P600 = new Color(9010175);
/* 228 */     public static final Color P700 = new Color(7957503);
/* 229 */     public static final Color P800 = new Color(6905087);
/* 230 */     public static final Color P900 = new Color(5062911);
/* 231 */     public static final Color A100 = new Color(-1476400129);
/* 232 */     public static final Color A200 = new Color(1694489343);
/* 233 */     public static final Color A400 = new Color(501855999);
/* 234 */     public static final Color A700 = new Color(12559871);
/* 235 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class GREEN {
/* 239 */     public static final Color P50 = new Color(-386536961);
/* 240 */     public static final Color P100 = new Color(-924399105);
/* 241 */     public static final Color P200 = new Color(-1512658945);
/* 242 */     public static final Color P300 = new Color(-2117630721);
/* 243 */     public static final Color P400 = new Color(1723558655);
/* 244 */     public static final Color P500 = new Color(1286557951);
/* 245 */     public static final Color P600 = new Color(1134577663);
/* 246 */     public static final Color P700 = new Color(948845823);
/* 247 */     public static final Color P800 = new Color(779956991);
/* 248 */     public static final Color P900 = new Color(459153663);
/* 249 */     public static final Color A100 = new Color(-1175008513);
/* 250 */     public static final Color A200 = new Color(1777381119);
/* 251 */     public static final Color A400 = new Color(15103743);
/* 252 */     public static final Color A700 = new Color(13128703);
/* 253 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class LIGHT_GREEN {
/* 257 */     public static final Color P50 = new Color(-235345409);
/* 258 */     public static final Color P100 = new Color(-588396289);
/* 259 */     public static final Color P200 = new Color(-975067649);
/* 260 */     public static final Color P300 = new Color(-1361739265);
/* 261 */     public static final Color P400 = new Color(-1664326145);
/* 262 */     public static final Color P500 = new Color(-1950135553);
/* 263 */     public static final Color P600 = new Color(2092122879);
/* 264 */     public static final Color P700 = new Color(1755265279);
/* 265 */     public static final Color P800 = new Color(1435185151);
/* 266 */     public static final Color P900 = new Color(862527231);
/* 267 */     public static final Color A100 = new Color(-855666433);
/* 268 */     public static final Color A200 = new Color(-1291888129);
/* 269 */     public static final Color A400 = new Color(1996424191);
/* 270 */     public static final Color A700 = new Color(1692211199);
/* 271 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class LIME {
/* 275 */     public static final Color P50 = new Color(-100931585);
/* 276 */     public static final Color P100 = new Color(-252394497);
/* 277 */     public static final Color P200 = new Color(-420569857);
/* 278 */     public static final Color P300 = new Color(-588810753);
/* 279 */     public static final Color P400 = new Color(-723429377);
/* 280 */     public static final Color P500 = new Color(-841205249);
/* 281 */     public static final Color P600 = new Color(-1060490241);
/* 282 */     public static final Color P700 = new Color(-1347146753);
/* 283 */     public static final Color P800 = new Color(-1633868545);
/* 284 */     public static final Color P900 = new Color(-2106124289);
/* 285 */     public static final Color A100 = new Color(-184581633);
/* 286 */     public static final Color A200 = new Color(-285261313);
/* 287 */     public static final Color A400 = new Color(-956366593);
/* 288 */     public static final Color A700 = new Color(-1360396033);
/* 289 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class YELLOW {
/* 293 */     public static final Color P50 = new Color(-137217);
/* 294 */     public static final Color P100 = new Color(-408321);
/* 295 */     public static final Color P200 = new Color(-680449);
/* 296 */     public static final Color P300 = new Color(-952577);
/* 297 */     public static final Color P400 = new Color(-1156865);
/* 298 */     public static final Color P500 = new Color(-1360897);
/* 299 */     public static final Color P600 = new Color(-36162049);
/* 300 */     public static final Color P700 = new Color(-71291393);
/* 301 */     public static final Color P800 = new Color(-106420737);
/* 302 */     public static final Color P900 = new Color(-176220161);
/* 303 */     public static final Color A100 = new Color(-29185);
/* 304 */     public static final Color A200 = new Color(-65281);
/* 305 */     public static final Color A400 = new Color(-1441537);
/* 306 */     public static final Color A700 = new Color(-2752257);
/* 307 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class AMBER {
/* 311 */     public static final Color P50 = new Color(-466433);
/* 312 */     public static final Color P100 = new Color(-1264641);
/* 313 */     public static final Color P200 = new Color(-2063617);
/* 314 */     public static final Color P300 = new Color(-2797569);
/* 315 */     public static final Color P400 = new Color(-3528449);
/* 316 */     public static final Color P500 = new Color(-4126721);
/* 317 */     public static final Color P600 = new Color(-5046017);
/* 318 */     public static final Color P700 = new Color(-6291201);
/* 319 */     public static final Color P800 = new Color(-7405313);
/* 320 */     public static final Color P900 = new Color(-9502465);
/* 321 */     public static final Color A100 = new Color(-1736705);
/* 322 */     public static final Color A200 = new Color(-2670337);
/* 323 */     public static final Color A400 = new Color(-3931905);
/* 324 */     public static final Color A700 = new Color(-5570305);
/* 325 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class ORANGE {
/* 329 */     public static final Color P50 = new Color(-794369);
/* 330 */     public static final Color P100 = new Color(-2051329);
/* 331 */     public static final Color P200 = new Color(-3374849);
/* 332 */     public static final Color P300 = new Color(-4764161);
/* 333 */     public static final Color P400 = new Color(-5822721);
/* 334 */     public static final Color P500 = new Color(-6815489);
/* 335 */     public static final Color P600 = new Color(-74710785);
/* 336 */     public static final Color P700 = new Color(-176422657);
/* 337 */     public static final Color P800 = new Color(-278134529);
/* 338 */     public static final Color P900 = new Color(-430898945);
/* 339 */     public static final Color A100 = new Color(-3047169);
/* 340 */     public static final Color A200 = new Color(-5553921);
/* 341 */     public static final Color A400 = new Color(-7274241);
/* 342 */     public static final Color A700 = new Color(-9633537);
/* 343 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class DEEP_ORANGE {
/* 347 */     public static final Color P50 = new Color(-68556801);
/* 348 */     public static final Color P100 = new Color(-3359489);
/* 349 */     public static final Color P200 = new Color(-5533185);
/* 350 */     public static final Color P300 = new Color(-7707137);
/* 351 */     public static final Color P400 = new Color(-9419777);
/* 352 */     public static final Color P500 = new Color(-11066625);
/* 353 */     public static final Color P600 = new Color(-196010241);
/* 354 */     public static final Color P700 = new Color(-431351297);
/* 355 */     public static final Color P800 = new Color(-666692097);
/* 356 */     public static final Color P900 = new Color(-1086976769);
/* 357 */     public static final Color A100 = new Color(-6389505);
/* 358 */     public static final Color A200 = new Color(-9551617);
/* 359 */     public static final Color A400 = new Color(-12779265);
/* 360 */     public static final Color A700 = new Color(-584318721);
/* 361 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900, A100, A200, A400, A700 };
/*     */   }
/*     */   
/*     */   public static class BROWN {
/* 365 */     public static final Color P50 = new Color(-269751809);
/* 366 */     public static final Color P100 = new Color(-674445057);
/* 367 */     public static final Color P200 = new Color(-1129667329);
/* 368 */     public static final Color P300 = new Color(-1584889857);
/* 369 */     public static final Color P400 = new Color(-1922145281);
/* 370 */     public static final Color P500 = new Color(2035632383);
/* 371 */     public static final Color P600 = new Color(1833714175);
/* 372 */     public static final Color P700 = new Color(1564489727);
/* 373 */     public static final Color P800 = new Color(1312042751);
/* 374 */     public static final Color P900 = new Color(1042752511);
/* 375 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900 };
/*     */   }
/*     */   
/*     */   public static class GREY {
/* 379 */     public static final Color P50 = new Color(-84215041);
/* 380 */     public static final Color P100 = new Color(-168430081);
/* 381 */     public static final Color P200 = new Color(-286331137);
/* 382 */     public static final Color P300 = new Color(-522133249);
/* 383 */     public static final Color P400 = new Color(-1111638529);
/* 384 */     public static final Color P500 = new Color(-1633771777);
/* 385 */     public static final Color P600 = new Color(1970632191);
/* 386 */     public static final Color P700 = new Color(1633772031);
/* 387 */     public static final Color P800 = new Color(1111638783);
/* 388 */     public static final Color P900 = new Color(555819519);
/* 389 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900 };
/*     */   }
/*     */   
/*     */   public static class BLUE_GREY {
/* 393 */     public static final Color P50 = new Color(-319819265);
/* 394 */     public static final Color P100 = new Color(-807871233);
/* 395 */     public static final Color P200 = new Color(-1329674753);
/* 396 */     public static final Color P300 = new Color(-1868255489);
/* 397 */     public static final Color P400 = new Color(2022743295);
/* 398 */     public static final Color P500 = new Color(1618840575);
/* 399 */     public static final Color P600 = new Color(1416526591);
/* 400 */     public static final Color P700 = new Color(1163551999);
/* 401 */     public static final Color P800 = new Color(927420415);
/* 402 */     public static final Color P900 = new Color(640825599);
/* 403 */     public static final Color[] values = new Color[] { P50, P100, P200, P300, P400, P500, P600, P700, P800, P900 };
/*     */   }
/*     */   
/* 406 */   public static final Color[][] allColors = new Color[][] { RED.values, PINK.values, PURPLE.values, DEEP_PURPLE.values, INDIGO.values, BLUE.values, LIGHT_BLUE.values, CYAN.values, TEAL.values, GREEN.values, LIGHT_GREEN.values, LIME.values, YELLOW.values, AMBER.values, ORANGE.values, DEEP_ORANGE.values, BROWN.values, GREY.values, BLUE_GREY.values };
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\MaterialColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */