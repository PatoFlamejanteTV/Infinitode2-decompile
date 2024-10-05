/*     */ package com.prineside.tdi2.enums;
/*     */ 
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public enum StatisticsType {
/*   8 */   WIP,
/*     */   
/*  10 */   TMS,
/*  11 */   TDD,
/*  12 */   TDDNC,
/*  13 */   TB,
/*  14 */   TS,
/*  15 */   TU,
/*  16 */   TEK,
/*     */   
/*  18 */   TMS_B,
/*  19 */   TDD_B,
/*  20 */   TB_B,
/*  21 */   TS_B,
/*  22 */   TU_B,
/*  23 */   TEK_B,
/*     */   
/*  25 */   TMS_C,
/*  26 */   TDD_C,
/*  27 */   TB_C,
/*  28 */   TS_C,
/*  29 */   TU_C,
/*  30 */   TEK_C,
/*     */   
/*  32 */   TMS_S,
/*  33 */   TDD_S,
/*  34 */   TB_S,
/*  35 */   TS_S,
/*  36 */   TU_S,
/*  37 */   TEK_S,
/*     */   
/*  39 */   TMS_F,
/*  40 */   TDD_F,
/*  41 */   TB_F,
/*  42 */   TS_F,
/*  43 */   TU_F,
/*  44 */   TEK_F,
/*     */   
/*  46 */   TMS_V,
/*  47 */   TDD_V,
/*  48 */   TB_V,
/*  49 */   TS_V,
/*  50 */   TU_V,
/*  51 */   TEK_V,
/*     */   
/*  53 */   TMS_SP,
/*  54 */   TDD_SP,
/*  55 */   TB_SP,
/*  56 */   TS_SP,
/*  57 */   TU_SP,
/*  58 */   TEK_SP,
/*     */   
/*  60 */   TMS_BL,
/*  61 */   TDD_BL,
/*  62 */   TB_BL,
/*  63 */   TS_BL,
/*  64 */   TU_BL,
/*  65 */   TEK_BL,
/*     */   
/*  67 */   TMS_M,
/*  68 */   TDD_M,
/*  69 */   TB_M,
/*  70 */   TS_M,
/*  71 */   TU_M,
/*  72 */   TEK_M,
/*     */   
/*  74 */   TMS_MI,
/*  75 */   TDD_MI,
/*  76 */   TB_MI,
/*  77 */   TS_MI,
/*  78 */   TU_MI,
/*  79 */   TEK_MI,
/*     */   
/*  81 */   TMS_A,
/*  82 */   TDD_A,
/*  83 */   TB_A,
/*  84 */   TS_A,
/*  85 */   TU_A,
/*  86 */   TEK_A,
/*     */   
/*  88 */   TMS_T,
/*  89 */   TDD_T,
/*  90 */   TB_T,
/*  91 */   TS_T,
/*  92 */   TU_T,
/*  93 */   TEK_T,
/*     */   
/*  95 */   TMS_MS,
/*  96 */   TDD_MS,
/*  97 */   TB_MS,
/*  98 */   TS_MS,
/*  99 */   TU_MS,
/* 100 */   TEK_MS,
/*     */   
/* 102 */   TMS_FL,
/* 103 */   TDD_FL,
/* 104 */   TB_FL,
/* 105 */   TS_FL,
/* 106 */   TU_FL,
/* 107 */   TEK_FL,
/*     */   
/* 109 */   TMS_L,
/* 110 */   TDD_L,
/* 111 */   TB_L,
/* 112 */   TS_L,
/* 113 */   TU_L,
/* 114 */   TEK_L,
/*     */   
/* 116 */   TMS_G,
/* 117 */   TDD_G,
/* 118 */   TB_G,
/* 119 */   TS_G,
/* 120 */   TU_G,
/* 121 */   TEK_G,
/*     */   
/* 123 */   TMS_CR,
/* 124 */   TDD_CR,
/* 125 */   TB_CR,
/* 126 */   TS_CR,
/* 127 */   TU_CR,
/* 128 */   TEK_CR,
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
/* 144 */   MMS,
/* 145 */   MB,
/* 146 */   MU,
/* 147 */   MMS_S,
/* 148 */   MB_S,
/* 149 */   MU_S,
/* 150 */   MMS_V,
/* 151 */   MB_V,
/* 152 */   MU_V,
/* 153 */   MMS_M,
/* 154 */   MB_M,
/* 155 */   MU_M,
/* 156 */   MMS_T,
/* 157 */   MB_T,
/* 158 */   MU_T,
/* 159 */   MMS_I,
/* 160 */   MB_I,
/* 161 */   MU_I,
/*     */   
/* 163 */   RG,
/* 164 */   RG_S,
/* 165 */   RG_V,
/* 166 */   RG_M,
/* 167 */   RG_T,
/* 168 */   RG_I,
/* 169 */   RS,
/* 170 */   RS_S,
/* 171 */   RS_V,
/* 172 */   RS_M,
/* 173 */   RS_T,
/* 174 */   RS_I,
/*     */   
/* 176 */   CG,
/* 177 */   EK,
/* 178 */   EP,
/* 179 */   GPG,
/* 180 */   GPS,
/* 181 */   BDS,
/* 182 */   WD,
/* 183 */   SG,
/* 184 */   AFPTG,
/* 185 */   BDFTPG,
/* 186 */   GGIG,
/* 187 */   EQCG,
/* 188 */   GS,
/* 189 */   GSUM,
/* 190 */   PT,
/* 191 */   PTEMWD,
/* 192 */   PTCL,
/* 193 */   PRT,
/* 194 */   WC,
/* 195 */   WCST,
/* 196 */   WCGC,
/* 197 */   WCGS,
/*     */ 
/*     */   
/* 200 */   SG_EK,
/* 201 */   SG_RM,
/* 202 */   SG_WCA,
/* 203 */   SG_WCL,
/*     */   
/* 205 */   EB,
/* 206 */   EB_P,
/* 207 */   EB_S,
/* 208 */   EB_I,
/* 209 */   EB_F,
/* 210 */   EB_TB,
/* 211 */   EB_BC,
/* 212 */   EB_CR,
/* 213 */   EB_BXP,
/* 214 */   EB_DE,
/* 215 */   EB_SL,
/* 216 */   EB_V,
/* 217 */   EB_INV,
/*     */   
/* 219 */   KEW_A,
/* 220 */   KEW_B,
/* 221 */   KEW_F,
/* 222 */   KEW_P,
/* 223 */   KEW_E,
/* 224 */   KEW_EL,
/* 225 */   KEW_L,
/*     */   
/* 227 */   MBS,
/* 228 */   TBS,
/*     */   
/* 230 */   RVV,
/* 231 */   RVW,
/*     */   
/* 233 */   RC,
/* 234 */   RCL,
/*     */   
/* 236 */   PQR,
/* 237 */   PMS,
/* 238 */   PPG,
/*     */   
/* 240 */   CG_B,
/* 241 */   CG_EK,
/* 242 */   CG_WC,
/* 243 */   CG_PG,
/* 244 */   CG_U,
/*     */   
/* 246 */   XPG_TG,
/* 247 */   XPG_EK,
/* 248 */   XPG_BB,
/* 249 */   XPG_EM,
/*     */   
/* 251 */   SOP;
/*     */   static {
/* 253 */     values = values();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final StatisticsType[] values;
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 261 */     return Game.i.statisticsManager.getStatisticsTitle(this).toString() + " (" + name() + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enums\StatisticsType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */