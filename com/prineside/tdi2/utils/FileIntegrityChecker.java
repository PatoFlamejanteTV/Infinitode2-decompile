/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class FileIntegrityChecker {
/*  14 */   private static final TLog a = TLog.forClass(FileIntegrityChecker.class);
/*     */ 
/*     */ 
/*     */   
/*  18 */   private static Array<String> b = null;
/*     */   
/*     */   public static Array<String> runTheTest() {
/*  21 */     if (b == null) {
/*  22 */       Game.i.assertInMainThread();
/*  23 */       b = new Array();
/*     */       try {
/*  25 */         ObjectSet objectSet = new ObjectSet();
/*     */         
/*  27 */         String str, arrayOfString[] = (str = AssetManager.localOrInternalFile("res/file-hashes.txt").readString("UTF-8")).split("\n");
/*  28 */         byte b1 = 0; int i; byte b2;
/*  29 */         for (i = (arrayOfString = arrayOfString).length, b2 = 0; b2 < i; b2++) {
/*  30 */           String str1 = (str1 = arrayOfString[b2]).trim();
/*  31 */           b1++;
/*     */           
/*  33 */           if (str1.length() != 0) {
/*     */             String str2;
/*     */             String[] arrayOfString1;
/*  36 */             if ((arrayOfString1 = str1.split("\\|")).length == 2) {
/*  37 */               String str3 = arrayOfString1[0];
/*  38 */               String str4 = arrayOfString1[1];
/*  39 */               objectSet.add(str3);
/*     */               FileHandle fileHandle1;
/*  41 */               if (!(fileHandle1 = AssetManager.localOrInternalFile(str3)).exists()) {
/*  42 */                 b.add("not exists: " + str3);
/*  43 */               } else if (fileHandle1.isDirectory()) {
/*  44 */                 b.add("is directory: " + str3);
/*     */               
/*     */               }
/*  47 */               else if (!(str2 = a(fileHandle1)).equals(str4)) {
/*  48 */                 b.add("hash mismatch: " + str3);
/*     */               } 
/*     */             } else {
/*     */               
/*  52 */               a.w("failed to read line %s in %s: %s, incorrect format", new Object[] { Integer.valueOf(b1), "res/file-hashes.txt", str2 });
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*     */         FileHandle fileHandle;
/*  58 */         if ((fileHandle = Gdx.files.local("scripts")).exists() && fileHandle.isDirectory()) {
/*  59 */           FileHandle[] arrayOfFileHandle1 = Gdx.files.local("scripts/").list();
/*  60 */           Array<String> array = new Array(); FileHandle[] arrayOfFileHandle2; int j; byte b4;
/*  61 */           for (j = (arrayOfFileHandle2 = arrayOfFileHandle1).length, b4 = 0; b4 < j; b4++) {
/*  62 */             FileHandle fileHandle1; if (!(fileHandle1 = arrayOfFileHandle2[b4]).name().equals(".definitions"))
/*     */             {
/*     */               
/*  65 */               a(fileHandle1, array);
/*     */             }
/*     */           } 
/*  68 */           for (byte b3 = 0; b3 < array.size; b3++) {
/*  69 */             String str1 = (String)array.get(b3);
/*  70 */             if (!objectSet.contains(str1)) {
/*  71 */               b.add("custom script: " + str1);
/*     */             }
/*     */           } 
/*     */         } else {
/*  75 */           a.d("skipped scripts check - dir not exists", new Object[0]);
/*     */         } 
/*  77 */       } catch (Throwable throwable) {
/*  78 */         a.e("failed to run file integrity check", new Object[] { throwable });
/*  79 */         b.add("failed to run the test: " + throwable.getMessage());
/*     */       } 
/*     */     } 
/*  82 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void generateHashListFile() {
/*  89 */     Array<String> array1 = new Array();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     for (String[] arrayOfString = { "0.1", "0.2", "0.3", "0.4", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.b1", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.b1", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.b1", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.b1", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.b1", "5.b2", "6.1", "6.2", "6.3", "6.4", "6.5", "6.6", "dev", "rumble", "zecred" }, arrayOfString = arrayOfString; i < 59; ) { String str = arrayOfString[i];
/* 103 */       array1.add("levels/" + str + ".json");
/* 104 */       array1.add("levels/maps/" + str + ".json");
/*     */       
/*     */       i++; }
/*     */     
/* 108 */     array1.add("res/luaj/class-list.txt");
/* 109 */     array1.add("res/luaj/forced-class-aliases.txt");
/* 110 */     array1.add("res/luaj/interfaces-priority.txt");
/* 111 */     array1.add("res/luaj/whitelist.txt");
/* 112 */     array1.add("res/achievements.json");
/* 113 */     array1.add("res/basic-level-stages.json");
/* 114 */     array1.add("res/core-tiles.json");
/* 115 */     array1.add("res/daily-loot.json");
/* 116 */     array1.add("res/game-values.json");
/* 117 */     array1.add("res/kryo-registry.txt");
/* 118 */     array1.add("res/researches.json");
/* 119 */     array1.add("res/tower-enemy-attack-matrix.json");
/* 120 */     array1.add("res/tower-enemy-damage-matrix.json");
/* 121 */     array1.add("res/tower-stats.json");
/* 122 */     array1.add("res/trophies.json");
/*     */     
/*     */     FileHandle[] arrayOfFileHandle;
/*     */     byte b;
/* 126 */     for (i = (arrayOfFileHandle = arrayOfFileHandle = Gdx.files.local("scripts/").list()).length, b = 0; b < i; b++) {
/* 127 */       FileHandle fileHandle; if (!(fileHandle = arrayOfFileHandle[b]).name().equals(".definitions"))
/*     */       {
/*     */         
/* 130 */         a(fileHandle, array1);
/*     */       }
/*     */     } 
/* 133 */     Threads.sortGdxArray(array1, (paramString1, paramString2) -> paramString1.compareTo(paramString2));
/*     */     
/* 135 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 137 */     for (Array.ArrayIterator<String> arrayIterator1 = array1.iterator(); arrayIterator1.hasNext(); ) { String str1 = arrayIterator1.next();
/* 138 */       String str2 = a(Gdx.files.local(str1));
/* 139 */       stringBuilder.append(str1).append("|").append(str2).append("\n"); }
/*     */ 
/*     */     
/* 142 */     Gdx.files.local("res/file-hashes.txt").writeString(stringBuilder.toString(), false, "UTF-8");
/* 143 */     a.i("Generated file hash list, checking integrity...", new Object[0]);
/*     */     
/*     */     Array<String> array2;
/* 146 */     if ((array2 = runTheTest()).size == 0) {
/* 147 */       a.i("file integrity test succeeded", new Object[0]); return;
/*     */     } 
/* 149 */     a.w("file integrity test failed:", new Object[0]);
/* 150 */     for (Array.ArrayIterator<String> arrayIterator2 = array2.iterator(); arrayIterator2.hasNext(); ) { String str = arrayIterator2.next();
/* 151 */       a.w("- " + str, new Object[0]); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private static String a(FileHandle paramFileHandle) {
/* 157 */     return StringFormatter.bytesMd5Hash(paramFileHandle.readBytes());
/*     */   }
/*     */   private static void a(FileHandle paramFileHandle, Array<String> paramArray) {
/*     */     FileHandle[] arrayOfFileHandle;
/* 161 */     if (paramFileHandle.isDirectory()) {
/*     */       int i; byte b;
/* 163 */       for (i = (arrayOfFileHandle = arrayOfFileHandle = paramFileHandle.list()).length, b = 0; b < i; b++) {
/* 164 */         FileHandle fileHandle; a(fileHandle = arrayOfFileHandle[b], paramArray);
/*     */       }  return;
/*     */     } 
/* 167 */     paramArray.add(arrayOfFileHandle.path());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\FileIntegrityChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */