/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
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
/*     */ public class XEvent
/*     */   extends Struct<XEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int XANY;
/*     */   public static final int XKEY;
/*     */   public static final int XBUTTON;
/*     */   public static final int XMOTION;
/*     */   public static final int XCROSSING;
/*     */   public static final int XFOCUS;
/*     */   public static final int XEXPOSE;
/*     */   public static final int XGRAPHICSEXPOSE;
/*     */   public static final int XNOEXPOSE;
/*     */   public static final int XVISIBILITY;
/*     */   public static final int XCREATEWINDOW;
/*     */   public static final int XDESTROYWINDOW;
/*     */   public static final int XUNMAP;
/*     */   public static final int XMAP;
/*     */   public static final int XMAPREQUEST;
/*     */   public static final int XREPARENT;
/*     */   public static final int XCONFIGURE;
/*     */   public static final int XGRAVITY;
/*     */   public static final int XRESIZEREQUEST;
/*     */   public static final int XCONFIGUREREQUEST;
/*     */   public static final int XCIRCULATE;
/*     */   public static final int XCIRCULATEREQUEST;
/*     */   public static final int XPROPERTY;
/*     */   public static final int XSELECTIONCLEAR;
/*     */   public static final int XSELECTIONREQUEST;
/*     */   public static final int XSELECTION;
/*     */   public static final int XCOLORMAP;
/*     */   public static final int XCLIENT;
/*     */   public static final int XMAPPING;
/*     */   public static final int XERROR;
/*     */   public static final int XKEYMAP;
/*     */   public static final int XGENERIC;
/*     */   public static final int XCOOKIE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/* 146 */     SIZEOF = (layout = __union(new Struct.Member[] { __member(4), __member(XAnyEvent.SIZEOF, XAnyEvent.ALIGNOF), __member(XKeyEvent.SIZEOF, XKeyEvent.ALIGNOF), __member(XButtonEvent.SIZEOF, XButtonEvent.ALIGNOF), __member(XMotionEvent.SIZEOF, XMotionEvent.ALIGNOF), __member(XCrossingEvent.SIZEOF, XCrossingEvent.ALIGNOF), __member(XFocusChangeEvent.SIZEOF, XFocusChangeEvent.ALIGNOF), __member(XExposeEvent.SIZEOF, XExposeEvent.ALIGNOF), __member(XGraphicsExposeEvent.SIZEOF, XGraphicsExposeEvent.ALIGNOF), __member(XNoExposeEvent.SIZEOF, XNoExposeEvent.ALIGNOF), __member(XVisibilityEvent.SIZEOF, XVisibilityEvent.ALIGNOF), __member(XCreateWindowEvent.SIZEOF, XCreateWindowEvent.ALIGNOF), __member(XDestroyWindowEvent.SIZEOF, XDestroyWindowEvent.ALIGNOF), __member(XUnmapEvent.SIZEOF, XUnmapEvent.ALIGNOF), __member(XMapEvent.SIZEOF, XMapEvent.ALIGNOF), __member(XMapRequestEvent.SIZEOF, XMapRequestEvent.ALIGNOF), __member(XReparentEvent.SIZEOF, XReparentEvent.ALIGNOF), __member(XConfigureEvent.SIZEOF, XConfigureEvent.ALIGNOF), __member(XGravityEvent.SIZEOF, XGravityEvent.ALIGNOF), __member(XResizeRequestEvent.SIZEOF, XResizeRequestEvent.ALIGNOF), __member(XConfigureRequestEvent.SIZEOF, XConfigureRequestEvent.ALIGNOF), __member(XCirculateEvent.SIZEOF, XCirculateEvent.ALIGNOF), __member(XCirculateRequestEvent.SIZEOF, XCirculateRequestEvent.ALIGNOF), __member(XPropertyEvent.SIZEOF, XPropertyEvent.ALIGNOF), __member(XSelectionClearEvent.SIZEOF, XSelectionClearEvent.ALIGNOF), __member(XSelectionRequestEvent.SIZEOF, XSelectionRequestEvent.ALIGNOF), __member(XSelectionEvent.SIZEOF, XSelectionEvent.ALIGNOF), __member(XColormapEvent.SIZEOF, XColormapEvent.ALIGNOF), __member(XClientMessageEvent.SIZEOF, XClientMessageEvent.ALIGNOF), __member(XMappingEvent.SIZEOF, XMappingEvent.ALIGNOF), __member(XErrorEvent.SIZEOF, XErrorEvent.ALIGNOF), __member(XKeymapEvent.SIZEOF, XKeymapEvent.ALIGNOF), __member(XGenericEvent.SIZEOF, XGenericEvent.ALIGNOF), __member(XGenericEventCookie.SIZEOF, XGenericEventCookie.ALIGNOF), __padding(24, CLONG_SIZE, true) })).getSize();
/* 147 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 149 */     TYPE = layout.offsetof(0);
/* 150 */     XANY = layout.offsetof(1);
/* 151 */     XKEY = layout.offsetof(2);
/* 152 */     XBUTTON = layout.offsetof(3);
/* 153 */     XMOTION = layout.offsetof(4);
/* 154 */     XCROSSING = layout.offsetof(5);
/* 155 */     XFOCUS = layout.offsetof(6);
/* 156 */     XEXPOSE = layout.offsetof(7);
/* 157 */     XGRAPHICSEXPOSE = layout.offsetof(8);
/* 158 */     XNOEXPOSE = layout.offsetof(9);
/* 159 */     XVISIBILITY = layout.offsetof(10);
/* 160 */     XCREATEWINDOW = layout.offsetof(11);
/* 161 */     XDESTROYWINDOW = layout.offsetof(12);
/* 162 */     XUNMAP = layout.offsetof(13);
/* 163 */     XMAP = layout.offsetof(14);
/* 164 */     XMAPREQUEST = layout.offsetof(15);
/* 165 */     XREPARENT = layout.offsetof(16);
/* 166 */     XCONFIGURE = layout.offsetof(17);
/* 167 */     XGRAVITY = layout.offsetof(18);
/* 168 */     XRESIZEREQUEST = layout.offsetof(19);
/* 169 */     XCONFIGUREREQUEST = layout.offsetof(20);
/* 170 */     XCIRCULATE = layout.offsetof(21);
/* 171 */     XCIRCULATEREQUEST = layout.offsetof(22);
/* 172 */     XPROPERTY = layout.offsetof(23);
/* 173 */     XSELECTIONCLEAR = layout.offsetof(24);
/* 174 */     XSELECTIONREQUEST = layout.offsetof(25);
/* 175 */     XSELECTION = layout.offsetof(26);
/* 176 */     XCOLORMAP = layout.offsetof(27);
/* 177 */     XCLIENT = layout.offsetof(28);
/* 178 */     XMAPPING = layout.offsetof(29);
/* 179 */     XERROR = layout.offsetof(30);
/* 180 */     XKEYMAP = layout.offsetof(31);
/* 181 */     XGENERIC = layout.offsetof(32);
/* 182 */     XCOOKIE = layout.offsetof(33);
/*     */   }
/*     */   
/*     */   protected XEvent(long paramLong, ByteBuffer paramByteBuffer) {
/* 186 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 191 */     return new XEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XEvent(ByteBuffer paramByteBuffer) {
/* 201 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 205 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 208 */     return ntype(address());
/*     */   } public XAnyEvent xany() {
/* 210 */     return nxany(address());
/*     */   } public XKeyEvent xkey() {
/* 212 */     return nxkey(address());
/*     */   } public XButtonEvent xbutton() {
/* 214 */     return nxbutton(address());
/*     */   } public XMotionEvent xmotion() {
/* 216 */     return nxmotion(address());
/*     */   } public XCrossingEvent xcrossing() {
/* 218 */     return nxcrossing(address());
/*     */   } public XFocusChangeEvent xfocus() {
/* 220 */     return nxfocus(address());
/*     */   } public XExposeEvent xexpose() {
/* 222 */     return nxexpose(address());
/*     */   } public XGraphicsExposeEvent xgraphicsexpose() {
/* 224 */     return nxgraphicsexpose(address());
/*     */   } public XNoExposeEvent xnoexpose() {
/* 226 */     return nxnoexpose(address());
/*     */   } public XVisibilityEvent xvisibility() {
/* 228 */     return nxvisibility(address());
/*     */   } public XCreateWindowEvent xcreatewindow() {
/* 230 */     return nxcreatewindow(address());
/*     */   } public XDestroyWindowEvent xdestroywindow() {
/* 232 */     return nxdestroywindow(address());
/*     */   } public XUnmapEvent xunmap() {
/* 234 */     return nxunmap(address());
/*     */   } public XMapEvent xmap() {
/* 236 */     return nxmap(address());
/*     */   } public XMapRequestEvent xmaprequest() {
/* 238 */     return nxmaprequest(address());
/*     */   } public XReparentEvent xreparent() {
/* 240 */     return nxreparent(address());
/*     */   } public XConfigureEvent xconfigure() {
/* 242 */     return nxconfigure(address());
/*     */   } public XGravityEvent xgravity() {
/* 244 */     return nxgravity(address());
/*     */   } public XResizeRequestEvent xresizerequest() {
/* 246 */     return nxresizerequest(address());
/*     */   } public XConfigureRequestEvent xconfigurerequest() {
/* 248 */     return nxconfigurerequest(address());
/*     */   } public XCirculateEvent xcirculate() {
/* 250 */     return nxcirculate(address());
/*     */   } public XCirculateRequestEvent xcirculaterequest() {
/* 252 */     return nxcirculaterequest(address());
/*     */   } public XPropertyEvent xproperty() {
/* 254 */     return nxproperty(address());
/*     */   } public XSelectionClearEvent xselectionclear() {
/* 256 */     return nxselectionclear(address());
/*     */   } public XSelectionRequestEvent xselectionrequest() {
/* 258 */     return nxselectionrequest(address());
/*     */   } public XSelectionEvent xselection() {
/* 260 */     return nxselection(address());
/*     */   } public XColormapEvent xcolormap() {
/* 262 */     return nxcolormap(address());
/*     */   } public XClientMessageEvent xclient() {
/* 264 */     return nxclient(address());
/*     */   } public XMappingEvent xmapping() {
/* 266 */     return nxmapping(address());
/*     */   } public XErrorEvent xerror() {
/* 268 */     return nxerror(address());
/*     */   } public XKeymapEvent xkeymap() {
/* 270 */     return nxkeymap(address());
/*     */   } public XGenericEvent xgeneric() {
/* 272 */     return nxgeneric(address());
/*     */   } public XGenericEventCookie xcookie() {
/* 274 */     return nxcookie(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent malloc() {
/* 280 */     return new XEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent calloc() {
/* 285 */     return new XEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent create() {
/* 290 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 291 */     return new XEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XEvent create(long paramLong) {
/* 296 */     return new XEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent createSafe(long paramLong) {
/* 302 */     return (paramLong == 0L) ? null : new XEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 311 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 320 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 329 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 330 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 340 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 346 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XEvent mallocStack() {
/* 352 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 354 */   public static XEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 356 */   public static XEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 358 */   public static XEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 360 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 362 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 364 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 366 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent malloc(MemoryStack paramMemoryStack) {
/* 374 */     return new XEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XEvent calloc(MemoryStack paramMemoryStack) {
/* 383 */     return new XEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 393 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 403 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 409 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static XAnyEvent nxany(long paramLong) {
/* 411 */     return XAnyEvent.create(paramLong + XANY);
/*     */   } public static XKeyEvent nxkey(long paramLong) {
/* 413 */     return XKeyEvent.create(paramLong + XKEY);
/*     */   } public static XButtonEvent nxbutton(long paramLong) {
/* 415 */     return XButtonEvent.create(paramLong + XBUTTON);
/*     */   } public static XMotionEvent nxmotion(long paramLong) {
/* 417 */     return XMotionEvent.create(paramLong + XMOTION);
/*     */   } public static XCrossingEvent nxcrossing(long paramLong) {
/* 419 */     return XCrossingEvent.create(paramLong + XCROSSING);
/*     */   } public static XFocusChangeEvent nxfocus(long paramLong) {
/* 421 */     return XFocusChangeEvent.create(paramLong + XFOCUS);
/*     */   } public static XExposeEvent nxexpose(long paramLong) {
/* 423 */     return XExposeEvent.create(paramLong + XEXPOSE);
/*     */   } public static XGraphicsExposeEvent nxgraphicsexpose(long paramLong) {
/* 425 */     return XGraphicsExposeEvent.create(paramLong + XGRAPHICSEXPOSE);
/*     */   } public static XNoExposeEvent nxnoexpose(long paramLong) {
/* 427 */     return XNoExposeEvent.create(paramLong + XNOEXPOSE);
/*     */   } public static XVisibilityEvent nxvisibility(long paramLong) {
/* 429 */     return XVisibilityEvent.create(paramLong + XVISIBILITY);
/*     */   } public static XCreateWindowEvent nxcreatewindow(long paramLong) {
/* 431 */     return XCreateWindowEvent.create(paramLong + XCREATEWINDOW);
/*     */   } public static XDestroyWindowEvent nxdestroywindow(long paramLong) {
/* 433 */     return XDestroyWindowEvent.create(paramLong + XDESTROYWINDOW);
/*     */   } public static XUnmapEvent nxunmap(long paramLong) {
/* 435 */     return XUnmapEvent.create(paramLong + XUNMAP);
/*     */   } public static XMapEvent nxmap(long paramLong) {
/* 437 */     return XMapEvent.create(paramLong + XMAP);
/*     */   } public static XMapRequestEvent nxmaprequest(long paramLong) {
/* 439 */     return XMapRequestEvent.create(paramLong + XMAPREQUEST);
/*     */   } public static XReparentEvent nxreparent(long paramLong) {
/* 441 */     return XReparentEvent.create(paramLong + XREPARENT);
/*     */   } public static XConfigureEvent nxconfigure(long paramLong) {
/* 443 */     return XConfigureEvent.create(paramLong + XCONFIGURE);
/*     */   } public static XGravityEvent nxgravity(long paramLong) {
/* 445 */     return XGravityEvent.create(paramLong + XGRAVITY);
/*     */   } public static XResizeRequestEvent nxresizerequest(long paramLong) {
/* 447 */     return XResizeRequestEvent.create(paramLong + XRESIZEREQUEST);
/*     */   } public static XConfigureRequestEvent nxconfigurerequest(long paramLong) {
/* 449 */     return XConfigureRequestEvent.create(paramLong + XCONFIGUREREQUEST);
/*     */   } public static XCirculateEvent nxcirculate(long paramLong) {
/* 451 */     return XCirculateEvent.create(paramLong + XCIRCULATE);
/*     */   } public static XCirculateRequestEvent nxcirculaterequest(long paramLong) {
/* 453 */     return XCirculateRequestEvent.create(paramLong + XCIRCULATEREQUEST);
/*     */   } public static XPropertyEvent nxproperty(long paramLong) {
/* 455 */     return XPropertyEvent.create(paramLong + XPROPERTY);
/*     */   } public static XSelectionClearEvent nxselectionclear(long paramLong) {
/* 457 */     return XSelectionClearEvent.create(paramLong + XSELECTIONCLEAR);
/*     */   } public static XSelectionRequestEvent nxselectionrequest(long paramLong) {
/* 459 */     return XSelectionRequestEvent.create(paramLong + XSELECTIONREQUEST);
/*     */   } public static XSelectionEvent nxselection(long paramLong) {
/* 461 */     return XSelectionEvent.create(paramLong + XSELECTION);
/*     */   } public static XColormapEvent nxcolormap(long paramLong) {
/* 463 */     return XColormapEvent.create(paramLong + XCOLORMAP);
/*     */   } public static XClientMessageEvent nxclient(long paramLong) {
/* 465 */     return XClientMessageEvent.create(paramLong + XCLIENT);
/*     */   } public static XMappingEvent nxmapping(long paramLong) {
/* 467 */     return XMappingEvent.create(paramLong + XMAPPING);
/*     */   } public static XErrorEvent nxerror(long paramLong) {
/* 469 */     return XErrorEvent.create(paramLong + XERROR);
/*     */   } public static XKeymapEvent nxkeymap(long paramLong) {
/* 471 */     return XKeymapEvent.create(paramLong + XKEYMAP);
/*     */   } public static XGenericEvent nxgeneric(long paramLong) {
/* 473 */     return XGenericEvent.create(paramLong + XGENERIC);
/*     */   } public static XGenericEventCookie nxcookie(long paramLong) {
/* 475 */     return XGenericEventCookie.create(paramLong + XCOOKIE);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 482 */     private static final XEvent ELEMENT_FACTORY = XEvent.create(-1L);
/*     */ 
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
/* 494 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 498 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 502 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 507 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XEvent getElementFactory() {
/* 512 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 516 */       return XEvent.ntype(address());
/*     */     } public XAnyEvent xany() {
/* 518 */       return XEvent.nxany(address());
/*     */     } public XKeyEvent xkey() {
/* 520 */       return XEvent.nxkey(address());
/*     */     } public XButtonEvent xbutton() {
/* 522 */       return XEvent.nxbutton(address());
/*     */     } public XMotionEvent xmotion() {
/* 524 */       return XEvent.nxmotion(address());
/*     */     } public XCrossingEvent xcrossing() {
/* 526 */       return XEvent.nxcrossing(address());
/*     */     } public XFocusChangeEvent xfocus() {
/* 528 */       return XEvent.nxfocus(address());
/*     */     } public XExposeEvent xexpose() {
/* 530 */       return XEvent.nxexpose(address());
/*     */     } public XGraphicsExposeEvent xgraphicsexpose() {
/* 532 */       return XEvent.nxgraphicsexpose(address());
/*     */     } public XNoExposeEvent xnoexpose() {
/* 534 */       return XEvent.nxnoexpose(address());
/*     */     } public XVisibilityEvent xvisibility() {
/* 536 */       return XEvent.nxvisibility(address());
/*     */     } public XCreateWindowEvent xcreatewindow() {
/* 538 */       return XEvent.nxcreatewindow(address());
/*     */     } public XDestroyWindowEvent xdestroywindow() {
/* 540 */       return XEvent.nxdestroywindow(address());
/*     */     } public XUnmapEvent xunmap() {
/* 542 */       return XEvent.nxunmap(address());
/*     */     } public XMapEvent xmap() {
/* 544 */       return XEvent.nxmap(address());
/*     */     } public XMapRequestEvent xmaprequest() {
/* 546 */       return XEvent.nxmaprequest(address());
/*     */     } public XReparentEvent xreparent() {
/* 548 */       return XEvent.nxreparent(address());
/*     */     } public XConfigureEvent xconfigure() {
/* 550 */       return XEvent.nxconfigure(address());
/*     */     } public XGravityEvent xgravity() {
/* 552 */       return XEvent.nxgravity(address());
/*     */     } public XResizeRequestEvent xresizerequest() {
/* 554 */       return XEvent.nxresizerequest(address());
/*     */     } public XConfigureRequestEvent xconfigurerequest() {
/* 556 */       return XEvent.nxconfigurerequest(address());
/*     */     } public XCirculateEvent xcirculate() {
/* 558 */       return XEvent.nxcirculate(address());
/*     */     } public XCirculateRequestEvent xcirculaterequest() {
/* 560 */       return XEvent.nxcirculaterequest(address());
/*     */     } public XPropertyEvent xproperty() {
/* 562 */       return XEvent.nxproperty(address());
/*     */     } public XSelectionClearEvent xselectionclear() {
/* 564 */       return XEvent.nxselectionclear(address());
/*     */     } public XSelectionRequestEvent xselectionrequest() {
/* 566 */       return XEvent.nxselectionrequest(address());
/*     */     } public XSelectionEvent xselection() {
/* 568 */       return XEvent.nxselection(address());
/*     */     } public XColormapEvent xcolormap() {
/* 570 */       return XEvent.nxcolormap(address());
/*     */     } public XClientMessageEvent xclient() {
/* 572 */       return XEvent.nxclient(address());
/*     */     } public XMappingEvent xmapping() {
/* 574 */       return XEvent.nxmapping(address());
/*     */     } public XErrorEvent xerror() {
/* 576 */       return XEvent.nxerror(address());
/*     */     } public XKeymapEvent xkeymap() {
/* 578 */       return XEvent.nxkeymap(address());
/*     */     } public XGenericEvent xgeneric() {
/* 580 */       return XEvent.nxgeneric(address());
/*     */     } public XGenericEventCookie xcookie() {
/* 582 */       return XEvent.nxcookie(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */