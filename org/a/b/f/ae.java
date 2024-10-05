/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.LineNumberReader;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.TreeMap;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
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
/*     */ 
/*     */ 
/*     */ public final class ae
/*     */ {
/*  45 */   private static final a a = c.a(ae.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     InputStream inputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  63 */     Object[][] arrayOfObject1 = { { "Adlam", { "adlm" } }, { "Ahom", { "ahom" } }, { "Anatolian_Hieroglyphs", { "hluw" } }, { "Arabic", { "arab" } }, { "Armenian", { "armn" } }, { "Avestan", { "avst" } }, { "Balinese", { "bali" } }, { "Bamum", { "bamu" } }, { "Bassa_Vah", { "bass" } }, { "Batak", { "batk" } }, { "Bengali", { "bng2", "beng" } }, { "Bhaiksuki", { "bhks" } }, { "Bopomofo", { "bopo" } }, { "Brahmi", { "brah" } }, { "Braille", { "brai" } }, { "Buginese", { "bugi" } }, { "Buhid", { "buhd" } }, { "Canadian_Aboriginal", { "cans" } }, { "Carian", { "cari" } }, { "Caucasian_Albanian", { "aghb" } }, { "Chakma", { "cakm" } }, { "Cham", { "cham" } }, { "Cherokee", { "cher" } }, { "Common", { "DFLT" } }, { "Coptic", { "copt" } }, { "Cuneiform", { "xsux" } }, { "Cypriot", { "cprt" } }, { "Cyrillic", { "cyrl" } }, { "Deseret", { "dsrt" } }, { "Devanagari", { "dev2", "deva" } }, { "Duployan", { "dupl" } }, { "Egyptian_Hieroglyphs", { "egyp" } }, { "Elbasan", { "elba" } }, { "Ethiopic", { "ethi" } }, { "Georgian", { "geor" } }, { "Glagolitic", { "glag" } }, { "Gothic", { "goth" } }, { "Grantha", { "gran" } }, { "Greek", { "grek" } }, { "Gujarati", { "gjr2", "gujr" } }, { "Gurmukhi", { "gur2", "guru" } }, { "Han", { "hani" } }, { "Hangul", { "hang" } }, { "Hanunoo", { "hano" } }, { "Hatran", { "hatr" } }, { "Hebrew", { "hebr" } }, { "Hiragana", { "kana" } }, { "Imperial_Aramaic", { "armi" } }, { "Inherited", { "Inherited" } }, { "Inscriptional_Pahlavi", { "phli" } }, { "Inscriptional_Parthian", { "prti" } }, { "Javanese", { "java" } }, { "Kaithi", { "kthi" } }, { "Kannada", { "knd2", "knda" } }, { "Katakana", { "kana" } }, { "Kayah_Li", { "kali" } }, { "Kharoshthi", { "khar" } }, { "Khmer", { "khmr" } }, { "Khojki", { "khoj" } }, { "Khudawadi", { "sind" } }, { "Lao", { "lao " } }, { "Latin", { "latn" } }, { "Lepcha", { "lepc" } }, { "Limbu", { "limb" } }, { "Linear_A", { "lina" } }, { "Linear_B", { "linb" } }, { "Lisu", { "lisu" } }, { "Lycian", { "lyci" } }, { "Lydian", { "lydi" } }, { "Mahajani", { "mahj" } }, { "Malayalam", { "mlm2", "mlym" } }, { "Mandaic", { "mand" } }, { "Manichaean", { "mani" } }, { "Marchen", { "marc" } }, { "Meetei_Mayek", { "mtei" } }, { "Mende_Kikakui", { "mend" } }, { "Meroitic_Cursive", { "merc" } }, { "Meroitic_Hieroglyphs", { "mero" } }, { "Miao", { "plrd" } }, { "Modi", { "modi" } }, { "Mongolian", { "mong" } }, { "Mro", { "mroo" } }, { "Multani", { "mult" } }, { "Myanmar", { "mym2", "mymr" } }, { "Nabataean", { "nbat" } }, { "Newa", { "newa" } }, { "New_Tai_Lue", { "talu" } }, { "Nko", { "nko " } }, { "Ogham", { "ogam" } }, { "Ol_Chiki", { "olck" } }, { "Old_Italic", { "ital" } }, { "Old_Hungarian", { "hung" } }, { "Old_North_Arabian", { "narb" } }, { "Old_Permic", { "perm" } }, { "Old_Persian", { "xpeo" } }, { "Old_South_Arabian", { "sarb" } }, { "Old_Turkic", { "orkh" } }, { "Oriya", { "ory2", "orya" } }, { "Osage", { "osge" } }, { "Osmanya", { "osma" } }, { "Pahawh_Hmong", { "hmng" } }, { "Palmyrene", { "palm" } }, { "Pau_Cin_Hau", { "pauc" } }, { "Phags_Pa", { "phag" } }, { "Phoenician", { "phnx" } }, { "Psalter_Pahlavi", { "phlp" } }, { "Rejang", { "rjng" } }, { "Runic", { "runr" } }, { "Samaritan", { "samr" } }, { "Saurashtra", { "saur" } }, { "Sharada", { "shrd" } }, { "Shavian", { "shaw" } }, { "Siddham", { "sidd" } }, { "SignWriting", { "sgnw" } }, { "Sinhala", { "sinh" } }, { "Sora_Sompeng", { "sora" } }, { "Sundanese", { "sund" } }, { "Syloti_Nagri", { "sylo" } }, { "Syriac", { "syrc" } }, { "Tagalog", { "tglg" } }, { "Tagbanwa", { "tagb" } }, { "Tai_Le", { "tale" } }, { "Tai_Tham", { "lana" } }, { "Tai_Viet", { "tavt" } }, { "Takri", { "takr" } }, { "Tamil", { "tml2", "taml" } }, { "Tangut", { "tang" } }, { "Telugu", { "tel2", "telu" } }, { "Thaana", { "thaa" } }, { "Thai", { "thai" } }, { "Tibetan", { "tibt" } }, { "Tifinagh", { "tfng" } }, { "Tirhuta", { "tirh" } }, { "Ugaritic", { "ugar" } }, { "Unknown", { "DFLT" } }, { "Vai", { "vai " } }, { "Warang_Citi", { "wara" } }, { "Yi", { "yi  " } } };
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
/* 208 */   private static final Map<String, String[]> b = (Map)new HashMap<String, String>(138); static { byte b; Object[][] arrayOfObject2;
/* 209 */     for (arrayOfObject2 = arrayOfObject1, b = 0; b < ''; b++) {
/*     */       
/* 211 */       Object[] arrayOfObject = arrayOfObject2[b], arrayOfObject = arrayOfObject;
/* 212 */       b.put((String)arrayOfObject[0], (String[])arrayOfObject[1]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     null = "/org/apache/fontbox/unicode/Scripts.txt";
/* 222 */     arrayOfObject2 = null;
/*     */ 
/*     */     
/*     */     try {
/* 226 */       if ((inputStream = ae.class.getResourceAsStream(null)) != null)
/*     */       {
/* 228 */         a(inputStream);
/*     */       }
/*     */       else
/*     */       {
/* 232 */         (new StringBuilder("Could not find '")).append(null).append("', mirroring char map will be empty: ");
/*     */       }
/*     */     
/* 235 */     } catch (IOException iOException) {
/*     */       
/* 237 */       (new StringBuilder("Could not parse Scripts.txt, mirroring char map will be empty: "))
/* 238 */         .append(iOException.getMessage());
/*     */     }
/*     */     finally {
/*     */       
/* 242 */       if (inputStream != null) {
/*     */         
/*     */         try {
/*     */           
/* 246 */           inputStream.close();
/*     */         }
/* 248 */         catch (IOException iOException) {}
/*     */       }
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] c;
/*     */ 
/*     */   
/*     */   private static String[] d;
/*     */ 
/*     */   
/*     */   private static void a(InputStream paramInputStream) {
/* 262 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(new af());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(paramInputStream));
/* 271 */     int[] arrayOfInt = { Integer.MIN_VALUE, Integer.MIN_VALUE };
/* 272 */     String str1 = null;
/*     */     
/*     */     String str2;
/*     */     
/* 276 */     while ((str2 = lineNumberReader.readLine()) != null) {
/*     */       int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 283 */       if ((i = str2.indexOf('#')) != -1)
/*     */       {
/* 285 */         str2 = str2.substring(0, i);
/*     */       }
/*     */       
/* 288 */       if (str2.length() >= 2) {
/*     */         int j;
/*     */ 
/*     */         
/*     */         StringTokenizer stringTokenizer;
/*     */ 
/*     */         
/* 295 */         if ((j = (stringTokenizer = new StringTokenizer(str2, ";")).countTokens()) >= 2) {
/*     */ 
/*     */ 
/*     */           
/* 299 */           String str3 = stringTokenizer.nextToken().trim();
/* 300 */           String str4 = stringTokenizer.nextToken().trim();
/* 301 */           int[] arrayOfInt1 = new int[2];
/*     */           int k;
/* 303 */           if ((k = str3.indexOf("..")) == -1) {
/*     */             
/* 305 */             arrayOfInt1[1] = Integer.parseInt(str3, 16); arrayOfInt1[0] = Integer.parseInt(str3, 16);
/*     */           }
/*     */           else {
/*     */             
/* 309 */             arrayOfInt1[0] = Integer.parseInt(str3.substring(0, k), 16);
/* 310 */             arrayOfInt1[1] = Integer.parseInt(str3.substring(k + 2), 16);
/*     */           } 
/* 312 */           if (arrayOfInt1[0] == arrayOfInt[1] + 1 && str4.equals(str1)) {
/*     */ 
/*     */             
/* 315 */             arrayOfInt[1] = arrayOfInt1[1];
/*     */             
/*     */             continue;
/*     */           } 
/* 319 */           treeMap.put(arrayOfInt1, str4);
/* 320 */           arrayOfInt = arrayOfInt1;
/* 321 */           str1 = str4;
/*     */         } 
/*     */       } 
/*     */     } 
/* 325 */     lineNumberReader.close();
/*     */     
/* 327 */     c = new int[treeMap.size()];
/* 328 */     d = new String[treeMap.size()];
/* 329 */     byte b = 0;
/* 330 */     for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
/*     */       
/* 332 */       c[b] = ((int[])entry.getKey())[0];
/* 333 */       d[b] = (String)entry.getValue();
/* 334 */       b++;
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
/*     */   private static String b(int paramInt) {
/* 346 */     c(paramInt);
/*     */     int i;
/* 348 */     if ((i = Character.getType(paramInt)) == 0)
/*     */     {
/* 350 */       return "Unknown";
/*     */     }
/*     */     
/* 353 */     if ((paramInt = Arrays.binarySearch(c, paramInt)) < 0)
/*     */     {
/* 355 */       paramInt = -paramInt - 2;
/*     */     }
/* 357 */     return d[paramInt];
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
/*     */   public static String[] a(int paramInt) {
/* 373 */     c(paramInt);
/* 374 */     String str = b(paramInt);
/* 375 */     return b.get(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void c(int paramInt) {
/* 380 */     if (paramInt < 0 || paramInt > 1114111)
/*     */     {
/* 382 */       throw new IllegalArgumentException("Invalid codepoint: " + paramInt);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */