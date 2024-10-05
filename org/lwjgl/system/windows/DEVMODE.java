/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ public class DEVMODE
/*     */   extends Struct<DEVMODE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int DMDEVICENAME;
/*     */   public static final int DMSPECVERSION;
/*     */   public static final int DMDRIVERVERSION;
/*     */   public static final int DMSIZE;
/*     */   public static final int DMDRIVEREXTRA;
/*     */   public static final int DMFIELDS;
/*     */   public static final int DMORIENTATION;
/*     */   public static final int DMPAPERSIZE;
/*     */   public static final int DMPAPERLENGTH;
/*     */   public static final int DMPAPERWIDTH;
/*     */   public static final int DMSCALE;
/*     */   public static final int DMCOPIES;
/*     */   public static final int DMDEFAULTSOURCE;
/*     */   public static final int DMPRINTQUALITY;
/*     */   public static final int DMPOSITION;
/*     */   public static final int DMDISPLAYORIENTATION;
/*     */   public static final int DMDISPLAYFIXEDOUTPUT;
/*     */   public static final int DMCOLOR;
/*     */   public static final int DMDUPLEX;
/*     */   public static final int DMYRESOLUTION;
/*     */   public static final int DMTTOPTION;
/*     */   public static final int DMCOLLATE;
/*     */   public static final int DMFORMNAME;
/*     */   public static final int DMLOGPIXELS;
/*     */   public static final int DMBITSPERPEL;
/*     */   public static final int DMPELSWIDTH;
/*     */   public static final int DMPELSHEIGHT;
/*     */   public static final int DMDISPLAYFLAGS;
/*     */   public static final int DMNUP;
/*     */   public static final int DMDISPLAYFREQUENCY;
/*     */   public static final int DMICMMETHOD;
/*     */   public static final int DMICMINTENT;
/*     */   public static final int DMMEDIATYPE;
/*     */   public static final int DMDITHERTYPE;
/*     */   public static final int DMRESERVED1;
/*     */   public static final int DMRESERVED2;
/*     */   public static final int DMPANNINGWIDTH;
/*     */   public static final int DMPANNINGHEIGHT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/* 172 */     SIZEOF = (layout = __struct(new Struct.Member[] { __array(2, 32), __member(2), __member(2), __member(2), __member(2), __member(4), (Struct.Member)__union(new Struct.Member[] { (Struct.Member)__struct(new Struct.Member[] { __member(2), __member(2), __member(2), __member(2), __member(2), __member(2), __member(2), __member(2) }), (Struct.Member)__struct(new Struct.Member[] { __member(POINTL.SIZEOF, POINTL.ALIGNOF), __member(4), __member(4) }) }), __member(2), __member(2), __member(2), __member(2), __member(2), __array(2, 32), __member(2), __member(4), __member(4), __member(4), (Struct.Member)__union(new Struct.Member[] { __member(4), __member(4) }), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/* 173 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 175 */     DMDEVICENAME = layout.offsetof(0);
/* 176 */     DMSPECVERSION = layout.offsetof(1);
/* 177 */     DMDRIVERVERSION = layout.offsetof(2);
/* 178 */     DMSIZE = layout.offsetof(3);
/* 179 */     DMDRIVEREXTRA = layout.offsetof(4);
/* 180 */     DMFIELDS = layout.offsetof(5);
/* 181 */     DMORIENTATION = layout.offsetof(8);
/* 182 */     DMPAPERSIZE = layout.offsetof(9);
/* 183 */     DMPAPERLENGTH = layout.offsetof(10);
/* 184 */     DMPAPERWIDTH = layout.offsetof(11);
/* 185 */     DMSCALE = layout.offsetof(12);
/* 186 */     DMCOPIES = layout.offsetof(13);
/* 187 */     DMDEFAULTSOURCE = layout.offsetof(14);
/* 188 */     DMPRINTQUALITY = layout.offsetof(15);
/* 189 */     DMPOSITION = layout.offsetof(17);
/* 190 */     DMDISPLAYORIENTATION = layout.offsetof(18);
/* 191 */     DMDISPLAYFIXEDOUTPUT = layout.offsetof(19);
/* 192 */     DMCOLOR = layout.offsetof(20);
/* 193 */     DMDUPLEX = layout.offsetof(21);
/* 194 */     DMYRESOLUTION = layout.offsetof(22);
/* 195 */     DMTTOPTION = layout.offsetof(23);
/* 196 */     DMCOLLATE = layout.offsetof(24);
/* 197 */     DMFORMNAME = layout.offsetof(25);
/* 198 */     DMLOGPIXELS = layout.offsetof(26);
/* 199 */     DMBITSPERPEL = layout.offsetof(27);
/* 200 */     DMPELSWIDTH = layout.offsetof(28);
/* 201 */     DMPELSHEIGHT = layout.offsetof(29);
/* 202 */     DMDISPLAYFLAGS = layout.offsetof(31);
/* 203 */     DMNUP = layout.offsetof(32);
/* 204 */     DMDISPLAYFREQUENCY = layout.offsetof(33);
/* 205 */     DMICMMETHOD = layout.offsetof(34);
/* 206 */     DMICMINTENT = layout.offsetof(35);
/* 207 */     DMMEDIATYPE = layout.offsetof(36);
/* 208 */     DMDITHERTYPE = layout.offsetof(37);
/* 209 */     DMRESERVED1 = layout.offsetof(38);
/* 210 */     DMRESERVED2 = layout.offsetof(39);
/* 211 */     DMPANNINGWIDTH = layout.offsetof(40);
/* 212 */     DMPANNINGHEIGHT = layout.offsetof(41);
/*     */   }
/*     */   
/*     */   protected DEVMODE(long paramLong, ByteBuffer paramByteBuffer) {
/* 216 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DEVMODE create(long paramLong, ByteBuffer paramByteBuffer) {
/* 221 */     return new DEVMODE(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DEVMODE(ByteBuffer paramByteBuffer) {
/* 231 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 235 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("TCHAR[32]")
/*     */   public ByteBuffer dmDeviceName() {
/* 242 */     return ndmDeviceName(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("TCHAR[32]")
/*     */   public String dmDeviceNameString() {
/* 248 */     return ndmDeviceNameString(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("WORD")
/*     */   public short dmSpecVersion() {
/* 254 */     return ndmSpecVersion(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmDriverVersion() {
/* 257 */     return ndmDriverVersion(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("WORD")
/*     */   public short dmSize() {
/* 263 */     return ndmSize(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("WORD")
/*     */   public short dmDriverExtra() {
/* 269 */     return ndmDriverExtra(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dmFields() {
/* 275 */     return ndmFields(address());
/*     */   } public short dmOrientation() {
/* 277 */     return ndmOrientation(address());
/*     */   } public short dmPaperSize() {
/* 279 */     return ndmPaperSize(address());
/*     */   } public short dmPaperLength() {
/* 281 */     return ndmPaperLength(address());
/*     */   } public short dmPaperWidth() {
/* 283 */     return ndmPaperWidth(address());
/*     */   } public short dmScale() {
/* 285 */     return ndmScale(address());
/*     */   } public short dmCopies() {
/* 287 */     return ndmCopies(address());
/*     */   } public short dmDefaultSource() {
/* 289 */     return ndmDefaultSource(address());
/*     */   } public short dmPrintQuality() {
/* 291 */     return ndmPrintQuality(address());
/*     */   }
/*     */ 
/*     */   
/*     */   public POINTL dmPosition() {
/* 296 */     return ndmPosition(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dmDisplayOrientation() {
/* 305 */     return ndmDisplayOrientation(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dmDisplayFixedOutput() {
/* 314 */     return ndmDisplayFixedOutput(address());
/*     */   } public short dmColor() {
/* 316 */     return ndmColor(address());
/*     */   } public short dmDuplex() {
/* 318 */     return ndmDuplex(address());
/*     */   } public short dmYResolution() {
/* 320 */     return ndmYResolution(address());
/*     */   } public short dmTTOption() {
/* 322 */     return ndmTTOption(address());
/*     */   } public short dmCollate() {
/* 324 */     return ndmCollate(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer dmFormName() {
/* 327 */     return ndmFormName(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String dmFormNameString() {
/* 330 */     return ndmFormNameString(address());
/*     */   } @NativeType("WORD")
/*     */   public short dmLogPixels() {
/* 333 */     return ndmLogPixels(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dmBitsPerPel() {
/* 339 */     return ndmBitsPerPel(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPelsWidth() {
/* 342 */     return ndmPelsWidth(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPelsHeight() {
/* 345 */     return ndmPelsHeight(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDisplayFlags() {
/* 348 */     return ndmDisplayFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmNup() {
/* 351 */     return ndmNup(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dmDisplayFrequency() {
/* 361 */     return ndmDisplayFrequency(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmICMMethod() {
/* 364 */     return ndmICMMethod(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmICMIntent() {
/* 367 */     return ndmICMIntent(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmMediaType() {
/* 370 */     return ndmMediaType(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmDitherType() {
/* 373 */     return ndmDitherType(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmReserved1() {
/* 376 */     return ndmReserved1(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmReserved2() {
/* 379 */     return ndmReserved2(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPanningWidth() {
/* 382 */     return ndmPanningWidth(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dmPanningHeight() {
/* 385 */     return ndmPanningHeight(address());
/*     */   }
/*     */   public DEVMODE dmSpecVersion(@NativeType("WORD") short paramShort) {
/* 388 */     ndmSpecVersion(address(), paramShort); return this;
/*     */   } public DEVMODE dmSize(@NativeType("WORD") short paramShort) {
/* 390 */     ndmSize(address(), paramShort); return this;
/*     */   } public DEVMODE dmDriverExtra(@NativeType("WORD") short paramShort) {
/* 392 */     ndmDriverExtra(address(), paramShort); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DEVMODE set(DEVMODE paramDEVMODE) {
/* 402 */     MemoryUtil.memCopy(paramDEVMODE.address(), address(), SIZEOF);
/* 403 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE malloc() {
/* 410 */     return new DEVMODE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE calloc() {
/* 415 */     return new DEVMODE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE create() {
/* 420 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 421 */     return new DEVMODE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DEVMODE create(long paramLong) {
/* 426 */     return new DEVMODE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE createSafe(long paramLong) {
/* 432 */     return (paramLong == 0L) ? null : new DEVMODE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 441 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 450 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 459 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 460 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 470 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 476 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static DEVMODE mallocStack() {
/* 482 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 484 */   public static DEVMODE callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 486 */   public static DEVMODE mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 488 */   public static DEVMODE callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 490 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 492 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 494 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 496 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE malloc(MemoryStack paramMemoryStack) {
/* 504 */     return new DEVMODE(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DEVMODE calloc(MemoryStack paramMemoryStack) {
/* 513 */     return new DEVMODE(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 523 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 533 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer ndmDeviceName(long paramLong) {
/* 539 */     return MemoryUtil.memByteBuffer(paramLong + DMDEVICENAME, 64);
/*     */   } public static String ndmDeviceNameString(long paramLong) {
/* 541 */     return MemoryUtil.memUTF16(paramLong + DMDEVICENAME);
/*     */   } public static short ndmSpecVersion(long paramLong) {
/* 543 */     return UNSAFE.getShort(null, paramLong + DMSPECVERSION);
/*     */   } public static short ndmDriverVersion(long paramLong) {
/* 545 */     return UNSAFE.getShort(null, paramLong + DMDRIVERVERSION);
/*     */   } public static short ndmSize(long paramLong) {
/* 547 */     return UNSAFE.getShort(null, paramLong + DMSIZE);
/*     */   } public static short ndmDriverExtra(long paramLong) {
/* 549 */     return UNSAFE.getShort(null, paramLong + DMDRIVEREXTRA);
/*     */   } public static int ndmFields(long paramLong) {
/* 551 */     return UNSAFE.getInt(null, paramLong + DMFIELDS);
/*     */   } public static short ndmOrientation(long paramLong) {
/* 553 */     return UNSAFE.getShort(null, paramLong + DMORIENTATION);
/*     */   } public static short ndmPaperSize(long paramLong) {
/* 555 */     return UNSAFE.getShort(null, paramLong + DMPAPERSIZE);
/*     */   } public static short ndmPaperLength(long paramLong) {
/* 557 */     return UNSAFE.getShort(null, paramLong + DMPAPERLENGTH);
/*     */   } public static short ndmPaperWidth(long paramLong) {
/* 559 */     return UNSAFE.getShort(null, paramLong + DMPAPERWIDTH);
/*     */   } public static short ndmScale(long paramLong) {
/* 561 */     return UNSAFE.getShort(null, paramLong + DMSCALE);
/*     */   } public static short ndmCopies(long paramLong) {
/* 563 */     return UNSAFE.getShort(null, paramLong + DMCOPIES);
/*     */   } public static short ndmDefaultSource(long paramLong) {
/* 565 */     return UNSAFE.getShort(null, paramLong + DMDEFAULTSOURCE);
/*     */   } public static short ndmPrintQuality(long paramLong) {
/* 567 */     return UNSAFE.getShort(null, paramLong + DMPRINTQUALITY);
/*     */   } public static POINTL ndmPosition(long paramLong) {
/* 569 */     return POINTL.create(paramLong + DMPOSITION);
/*     */   } public static int ndmDisplayOrientation(long paramLong) {
/* 571 */     return UNSAFE.getInt(null, paramLong + DMDISPLAYORIENTATION);
/*     */   } public static int ndmDisplayFixedOutput(long paramLong) {
/* 573 */     return UNSAFE.getInt(null, paramLong + DMDISPLAYFIXEDOUTPUT);
/*     */   } public static short ndmColor(long paramLong) {
/* 575 */     return UNSAFE.getShort(null, paramLong + DMCOLOR);
/*     */   } public static short ndmDuplex(long paramLong) {
/* 577 */     return UNSAFE.getShort(null, paramLong + DMDUPLEX);
/*     */   } public static short ndmYResolution(long paramLong) {
/* 579 */     return UNSAFE.getShort(null, paramLong + DMYRESOLUTION);
/*     */   } public static short ndmTTOption(long paramLong) {
/* 581 */     return UNSAFE.getShort(null, paramLong + DMTTOPTION);
/*     */   } public static short ndmCollate(long paramLong) {
/* 583 */     return UNSAFE.getShort(null, paramLong + DMCOLLATE);
/*     */   } public static ByteBuffer ndmFormName(long paramLong) {
/* 585 */     return MemoryUtil.memByteBuffer(paramLong + DMFORMNAME, 64);
/*     */   } public static String ndmFormNameString(long paramLong) {
/* 587 */     return MemoryUtil.memUTF16(paramLong + DMFORMNAME);
/*     */   } public static short ndmLogPixels(long paramLong) {
/* 589 */     return UNSAFE.getShort(null, paramLong + DMLOGPIXELS);
/*     */   } public static int ndmBitsPerPel(long paramLong) {
/* 591 */     return UNSAFE.getInt(null, paramLong + DMBITSPERPEL);
/*     */   } public static int ndmPelsWidth(long paramLong) {
/* 593 */     return UNSAFE.getInt(null, paramLong + DMPELSWIDTH);
/*     */   } public static int ndmPelsHeight(long paramLong) {
/* 595 */     return UNSAFE.getInt(null, paramLong + DMPELSHEIGHT);
/*     */   } public static int ndmDisplayFlags(long paramLong) {
/* 597 */     return UNSAFE.getInt(null, paramLong + DMDISPLAYFLAGS);
/*     */   } public static int ndmNup(long paramLong) {
/* 599 */     return UNSAFE.getInt(null, paramLong + DMNUP);
/*     */   } public static int ndmDisplayFrequency(long paramLong) {
/* 601 */     return UNSAFE.getInt(null, paramLong + DMDISPLAYFREQUENCY);
/*     */   } public static int ndmICMMethod(long paramLong) {
/* 603 */     return UNSAFE.getInt(null, paramLong + DMICMMETHOD);
/*     */   } public static int ndmICMIntent(long paramLong) {
/* 605 */     return UNSAFE.getInt(null, paramLong + DMICMINTENT);
/*     */   } public static int ndmMediaType(long paramLong) {
/* 607 */     return UNSAFE.getInt(null, paramLong + DMMEDIATYPE);
/*     */   } public static int ndmDitherType(long paramLong) {
/* 609 */     return UNSAFE.getInt(null, paramLong + DMDITHERTYPE);
/*     */   } public static int ndmReserved1(long paramLong) {
/* 611 */     return UNSAFE.getInt(null, paramLong + DMRESERVED1);
/*     */   } public static int ndmReserved2(long paramLong) {
/* 613 */     return UNSAFE.getInt(null, paramLong + DMRESERVED2);
/*     */   } public static int ndmPanningWidth(long paramLong) {
/* 615 */     return UNSAFE.getInt(null, paramLong + DMPANNINGWIDTH);
/*     */   } public static int ndmPanningHeight(long paramLong) {
/* 617 */     return UNSAFE.getInt(null, paramLong + DMPANNINGHEIGHT);
/*     */   }
/*     */   public static void ndmSpecVersion(long paramLong, short paramShort) {
/* 620 */     UNSAFE.putShort(null, paramLong + DMSPECVERSION, paramShort);
/*     */   } public static void ndmSize(long paramLong, short paramShort) {
/* 622 */     UNSAFE.putShort(null, paramLong + DMSIZE, paramShort);
/*     */   } public static void ndmDriverExtra(long paramLong, short paramShort) {
/* 624 */     UNSAFE.putShort(null, paramLong + DMDRIVEREXTRA, paramShort);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DEVMODE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 631 */     private static final DEVMODE ELEMENT_FACTORY = DEVMODE.create(-1L);
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
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 643 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / DEVMODE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 647 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 651 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 656 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected DEVMODE getElementFactory() {
/* 661 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("TCHAR[32]")
/*     */     public ByteBuffer dmDeviceName() {
/* 666 */       return DEVMODE.ndmDeviceName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String dmDeviceNameString() {
/* 669 */       return DEVMODE.ndmDeviceNameString(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmSpecVersion() {
/* 672 */       return DEVMODE.ndmSpecVersion(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmDriverVersion() {
/* 675 */       return DEVMODE.ndmDriverVersion(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmSize() {
/* 678 */       return DEVMODE.ndmSize(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmDriverExtra() {
/* 681 */       return DEVMODE.ndmDriverExtra(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmFields() {
/* 684 */       return DEVMODE.ndmFields(address());
/*     */     } public short dmOrientation() {
/* 686 */       return DEVMODE.ndmOrientation(address());
/*     */     } public short dmPaperSize() {
/* 688 */       return DEVMODE.ndmPaperSize(address());
/*     */     } public short dmPaperLength() {
/* 690 */       return DEVMODE.ndmPaperLength(address());
/*     */     } public short dmPaperWidth() {
/* 692 */       return DEVMODE.ndmPaperWidth(address());
/*     */     } public short dmScale() {
/* 694 */       return DEVMODE.ndmScale(address());
/*     */     } public short dmCopies() {
/* 696 */       return DEVMODE.ndmCopies(address());
/*     */     } public short dmDefaultSource() {
/* 698 */       return DEVMODE.ndmDefaultSource(address());
/*     */     } public short dmPrintQuality() {
/* 700 */       return DEVMODE.ndmPrintQuality(address());
/*     */     } public POINTL dmPosition() {
/* 702 */       return DEVMODE.ndmPosition(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayOrientation() {
/* 705 */       return DEVMODE.ndmDisplayOrientation(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFixedOutput() {
/* 708 */       return DEVMODE.ndmDisplayFixedOutput(address());
/*     */     } public short dmColor() {
/* 710 */       return DEVMODE.ndmColor(address());
/*     */     } public short dmDuplex() {
/* 712 */       return DEVMODE.ndmDuplex(address());
/*     */     } public short dmYResolution() {
/* 714 */       return DEVMODE.ndmYResolution(address());
/*     */     } public short dmTTOption() {
/* 716 */       return DEVMODE.ndmTTOption(address());
/*     */     } public short dmCollate() {
/* 718 */       return DEVMODE.ndmCollate(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer dmFormName() {
/* 721 */       return DEVMODE.ndmFormName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String dmFormNameString() {
/* 724 */       return DEVMODE.ndmFormNameString(address());
/*     */     } @NativeType("WORD")
/*     */     public short dmLogPixels() {
/* 727 */       return DEVMODE.ndmLogPixels(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmBitsPerPel() {
/* 730 */       return DEVMODE.ndmBitsPerPel(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPelsWidth() {
/* 733 */       return DEVMODE.ndmPelsWidth(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPelsHeight() {
/* 736 */       return DEVMODE.ndmPelsHeight(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFlags() {
/* 739 */       return DEVMODE.ndmDisplayFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmNup() {
/* 742 */       return DEVMODE.ndmNup(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDisplayFrequency() {
/* 745 */       return DEVMODE.ndmDisplayFrequency(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmICMMethod() {
/* 748 */       return DEVMODE.ndmICMMethod(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmICMIntent() {
/* 751 */       return DEVMODE.ndmICMIntent(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmMediaType() {
/* 754 */       return DEVMODE.ndmMediaType(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmDitherType() {
/* 757 */       return DEVMODE.ndmDitherType(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmReserved1() {
/* 760 */       return DEVMODE.ndmReserved1(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmReserved2() {
/* 763 */       return DEVMODE.ndmReserved2(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPanningWidth() {
/* 766 */       return DEVMODE.ndmPanningWidth(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dmPanningHeight() {
/* 769 */       return DEVMODE.ndmPanningHeight(address());
/*     */     }
/*     */     public Buffer dmSpecVersion(@NativeType("WORD") short param1Short) {
/* 772 */       DEVMODE.ndmSpecVersion(address(), param1Short); return this;
/*     */     } public Buffer dmSize(@NativeType("WORD") short param1Short) {
/* 774 */       DEVMODE.ndmSize(address(), param1Short); return this;
/*     */     } public Buffer dmDriverExtra(@NativeType("WORD") short param1Short) {
/* 776 */       DEVMODE.ndmDriverExtra(address(), param1Short); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\DEVMODE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */