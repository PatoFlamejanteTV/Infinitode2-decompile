/*      */ package org.lwjgl.system.windows;public class User32 { public static final int WS_OVERLAPPED = 0; public static final int WS_POPUP = -2147483648; public static final int WS_CHILD = 1073741824; public static final int WS_MINIMIZE = 536870912; public static final int WS_VISIBLE = 268435456; public static final int WS_DISABLED = 134217728; public static final int WS_CLIPSIBLINGS = 67108864; public static final int WS_CLIPCHILDREN = 33554432; public static final int WS_MAXIMIZE = 16777216; public static final int WS_CAPTION = 12582912; public static final int WS_BORDER = 8388608; public static final int WS_DLGFRAME = 4194304; public static final int WS_VSCROLL = 2097152; public static final int WS_HSCROLL = 1048576; public static final int WS_SYSMENU = 524288; public static final int WS_THICKFRAME = 262144; public static final int WS_GROUP = 131072; public static final int WS_TABSTOP = 65536; public static final int WS_MINIMIZEBOX = 131072; public static final int WS_MAXIMIZEBOX = 65536; public static final int WS_OVERLAPPEDWINDOW = 13565952; public static final int WS_POPUPWINDOW = -2138570752; public static final int WS_CHILDWINDOW = 1073741824; public static final int WS_TILED = 0; public static final int WS_ICONIC = 536870912; public static final int WS_SIZEBOX = 262144; public static final int WS_TILEDWINDOW = 13565952; public static final int WS_EX_DLGMODALFRAME = 1; public static final int WS_EX_NOPARENTNOTIFY = 4; public static final int WS_EX_TOPMOST = 8; public static final int WS_EX_ACCEPTFILES = 16; public static final int WS_EX_TRANSPARENT = 32; public static final int WS_EX_MDICHILD = 64; public static final int WS_EX_TOOLWINDOW = 128; public static final int WS_EX_WINDOWEDGE = 256; public static final int WS_EX_CLIENTEDGE = 512; public static final int WS_EX_CONTEXTHELP = 1024; public static final int WS_EX_RIGHT = 4096; public static final int WS_EX_LEFT = 0; public static final int WS_EX_RTLREADING = 8192; public static final int WS_EX_LTRREADING = 0; public static final int WS_EX_LEFTSCROLLBAR = 16384; public static final int WS_EX_RIGHTSCROLLBAR = 0; public static final int WS_EX_CONTROLPARENT = 65536; public static final int WS_EX_STATICEDGE = 131072; public static final int WS_EX_APPWINDOW = 262144; public static final int WS_EX_OVERLAPPEDWINDOW = 768; public static final int WS_EX_PALETTEWINDOW = 392; public static final int WS_EX_LAYERED = 524288; public static final int WS_EX_NOINHERITLAYOUT = 1048576; public static final int WS_EX_LAYOUTRTL = 4194304; public static final int WS_EX_COMPOSITED = 33554432; public static final int WS_EX_NOACTIVATE = 134217728; public static final int CW_USEDEFAULT = -2147483648; public static final int CS_VREDRAW = 1; public static final int CS_HREDRAW = 2; public static final int CS_DBLCLKS = 8; public static final int CS_OWNDC = 32; public static final int CS_CLASSDC = 64; public static final int CS_PARENTDC = 128; public static final int CS_NOCLOSE = 512; public static final int CS_SAVEBITS = 2048; public static final int CS_BYTEALIGNCLIENT = 4096; public static final int CS_BYTEALIGNWINDOW = 8192; public static final int CS_GLOBALCLASS = 16384; public static final int CS_IME = 65536; public static final int CS_DROPSHADOW = 131072; public static final int WM_NULL = 0; public static final int WM_CREATE = 1; public static final int WM_DESTROY = 2; public static final int WM_MOVE = 3; public static final int WM_SIZE = 5; public static final int WM_ACTIVATE = 6; public static final int WM_SETFOCUS = 7; public static final int WM_KILLFOCUS = 8; public static final int WM_ENABLE = 10; public static final int WM_SETREDRAW = 11; public static final int WM_SETTEXT = 12; public static final int WM_GETTEXT = 13; public static final int WM_GETTEXTLENGTH = 14; public static final int WM_PAINT = 15; public static final int WM_CLOSE = 16; public static final int WM_QUERYENDSESSION = 17; public static final int WM_QUERYOPEN = 19; public static final int WM_ENDSESSION = 22; public static final int WM_QUIT = 18; public static final int WM_ERASEBKGND = 20; public static final int WM_SYSCOLORCHANGE = 21; public static final int WM_SHOWWINDOW = 24; public static final int WM_WININICHANGE = 26; public static final int WM_SETTINGCHANGE = 26; public static final int WM_DEVMODECHANGE = 27; public static final int WM_ACTIVATEAPP = 28; public static final int WM_FONTCHANGE = 29; public static final int WM_TIMECHANGE = 30; public static final int WM_CANCELMODE = 31; public static final int WM_SETCURSOR = 32; public static final int WM_MOUSEACTIVATE = 33; public static final int WM_CHILDACTIVATE = 34; public static final int WM_QUEUESYNC = 35; public static final int WM_GETMINMAXINFO = 36; public static final int WM_PAINTICON = 38; public static final int WM_ICONERASEBKGND = 39; public static final int WM_NEXTDLGCTL = 40; public static final int WM_SPOOLERSTATUS = 42; public static final int WM_DRAWITEM = 43; public static final int WM_MEASUREITEM = 44; public static final int WM_DELETEITEM = 45; public static final int WM_VKEYTOITEM = 46; public static final int WM_CHARTOITEM = 47; public static final int WM_SETFONT = 48; public static final int WM_GETFONT = 49; public static final int WM_SETHOTKEY = 50; public static final int WM_GETHOTKEY = 51; public static final int WM_QUERYDRAGICON = 55; public static final int WM_COMPAREITEM = 57; public static final int WM_GETOBJECT = 61; public static final int WM_COMPACTING = 65; public static final int WM_COMMNOTIFY = 68; public static final int WM_WINDOWPOSCHANGING = 70; public static final int WM_WINDOWPOSCHANGED = 71; public static final int WM_POWER = 72; public static final int WM_COPYDATA = 74; public static final int WM_CANCELJOURNAL = 75; public static final int WM_NOTIFY = 78; public static final int WM_INPUTLANGCHANGEREQUEST = 80; public static final int WM_INPUTLANGCHANGE = 81; public static final int WM_TCARD = 82; public static final int WM_HELP = 83; public static final int WM_USERCHANGED = 84; public static final int WM_NOTIFYFORMAT = 85; public static final int WM_CONTEXTMENU = 123; public static final int WM_STYLECHANGING = 124; public static final int WM_STYLECHANGED = 125; public static final int WM_DISPLAYCHANGE = 126; public static final int WM_GETICON = 127; public static final int WM_SETICON = 128; public static final int WM_NCCREATE = 129; public static final int WM_NCDESTROY = 130; public static final int WM_NCCALCSIZE = 131; public static final int WM_NCHITTEST = 132; public static final int WM_NCPAINT = 133; public static final int WM_NCACTIVATE = 134; public static final int WM_GETDLGCODE = 135; public static final int WM_SYNCPAINT = 136; public static final int WM_NCMOUSEMOVE = 160; public static final int WM_NCLBUTTONDOWN = 161; public static final int WM_NCLBUTTONUP = 162; public static final int WM_NCLBUTTONDBLCLK = 163; public static final int WM_NCRBUTTONDOWN = 164; public static final int WM_NCRBUTTONUP = 165; public static final int WM_NCRBUTTONDBLCLK = 166; public static final int WM_NCMBUTTONDOWN = 167; public static final int WM_NCMBUTTONUP = 168; public static final int WM_NCMBUTTONDBLCLK = 169; public static final int WM_NCXBUTTONDOWN = 171; public static final int WM_NCXBUTTONUP = 172; public static final int WM_NCXBUTTONDBLCLK = 173; public static final int WM_INPUT_DEVICE_CHANGE = 254; public static final int WM_INPUT = 255; public static final int WM_KEYFIRST = 256; public static final int WM_KEYDOWN = 256; public static final int WM_KEYUP = 257; public static final int WM_CHAR = 258; public static final int WM_DEADCHAR = 259; public static final int WM_SYSKEYDOWN = 260; public static final int WM_SYSKEYUP = 261; public static final int WM_SYSCHAR = 262; public static final int WM_SYSDEADCHAR = 263; public static final int WM_UNICHAR = 265; public static final int UNICODE_NOCHAR = 65535; public static final int WM_IME_STARTCOMPOSITION = 269; public static final int WM_IME_ENDCOMPOSITION = 270; public static final int WM_IME_COMPOSITION = 271; public static final int WM_IME_KEYLAST = 271; public static final int WM_INITDIALOG = 272; public static final int WM_COMMAND = 273; public static final int WM_SYSCOMMAND = 274; public static final int WM_TIMER = 275; public static final int WM_HSCROLL = 276; public static final int WM_VSCROLL = 277;
/*      */   public static final int WM_INITMENU = 278;
/*      */   public static final int WM_INITMENUPOPUP = 279;
/*      */   public static final int WM_GESTURE = 281;
/*      */   public static final int WM_GESTURENOTIFY = 282;
/*      */   public static final int WM_MENUSELECT = 287;
/*      */   public static final int WM_MENUCHAR = 288;
/*      */   public static final int WM_ENTERIDLE = 289;
/*      */   public static final int WM_MENURBUTTONUP = 290;
/*      */   public static final int WM_MENUDRAG = 291;
/*      */   public static final int WM_MENUGETOBJECT = 292;
/*      */   public static final int WM_UNINITMENUPOPUP = 293;
/*      */   public static final int WM_MENUCOMMAND = 294;
/*      */   public static final int WM_CHANGEUISTATE = 295;
/*      */   public static final int WM_UPDATEUISTATE = 296;
/*      */   public static final int WM_QUERYUISTATE = 297;
/*      */   public static final int WM_CTLCOLORMSGBOX = 306;
/*      */   public static final int WM_CTLCOLOREDIT = 307;
/*      */   public static final int WM_CTLCOLORLISTBOX = 308;
/*      */   public static final int WM_CTLCOLORBTN = 309;
/*      */   public static final int WM_CTLCOLORDLG = 310;
/*      */   public static final int WM_CTLCOLORSCROLLBAR = 311;
/*   23 */   private static final SharedLibrary USER32 = Library.loadNative(User32.class, "org.lwjgl", "user32"); public static final int WM_CTLCOLORSTATIC = 312; public static final int MN_GETHMENU = 481; public static final int WM_MOUSEFIRST = 512; public static final int WM_MOUSEMOVE = 512; public static final int WM_LBUTTONDOWN = 513; public static final int WM_LBUTTONUP = 514; public static final int WM_LBUTTONDBLCLK = 515; public static final int WM_RBUTTONDOWN = 516; public static final int WM_RBUTTONUP = 517; public static final int WM_RBUTTONDBLCLK = 518; public static final int WM_MBUTTONDOWN = 519; public static final int WM_MBUTTONUP = 520; public static final int WM_MBUTTONDBLCLK = 521; public static final int WM_MOUSEWHEEL = 522; public static final int WM_XBUTTONDOWN = 523; public static final int WM_XBUTTONUP = 524; public static final int WM_XBUTTONDBLCLK = 525; public static final int WM_MOUSEHWHEEL = 526; public static final int WM_PARENTNOTIFY = 528; public static final int WM_ENTERMENULOOP = 529; public static final int WM_EXITMENULOOP = 530; public static final int WM_NEXTMENU = 531; public static final int WM_SIZING = 532; public static final int WM_CAPTURECHANGED = 533; public static final int WM_MOVING = 534; public static final int WM_POWERBROADCAST = 536; public static final int WM_DEVICECHANGE = 537; public static final int WM_MDICREATE = 544; public static final int WM_MDIDESTROY = 545; public static final int WM_MDIACTIVATE = 546; public static final int WM_MDIRESTORE = 547; public static final int WM_MDINEXT = 548; public static final int WM_MDIMAXIMIZE = 549; public static final int WM_MDITILE = 550; public static final int WM_MDICASCADE = 551; public static final int WM_MDIICONARRANGE = 552; public static final int WM_MDIGETACTIVE = 553; public static final int WM_MDISETMENU = 560; public static final int WM_ENTERSIZEMOVE = 561; public static final int WM_EXITSIZEMOVE = 562; public static final int WM_DROPFILES = 563; public static final int WM_MDIREFRESHMENU = 564; public static final int WM_TOUCH = 576; public static final int WM_IME_SETCONTEXT = 641; public static final int WM_IME_NOTIFY = 642; public static final int WM_IME_CONTROL = 643; public static final int WM_IME_COMPOSITIONFULL = 644; public static final int WM_IME_SELECT = 645; public static final int WM_IME_CHAR = 646; public static final int WM_IME_REQUEST = 648; public static final int WM_IME_KEYDOWN = 656; public static final int WM_IME_KEYUP = 657; public static final int WM_MOUSEHOVER = 673; public static final int WM_MOUSELEAVE = 675; public static final int WM_NCMOUSEHOVER = 672; public static final int WM_NCMOUSELEAVE = 674; public static final int WM_WTSSESSION_CHANGE = 689; public static final int WM_TABLET_FIRST = 704; public static final int WM_TABLET_LAST = 735; public static final int WM_CUT = 768; public static final int WM_COPY = 769; public static final int WM_PASTE = 770; public static final int WM_CLEAR = 771; public static final int WM_UNDO = 772; public static final int WM_RENDERFORMAT = 773; public static final int WM_RENDERALLFORMATS = 774; public static final int WM_DESTROYCLIPBOARD = 775; public static final int WM_DRAWCLIPBOARD = 776; public static final int WM_PAINTCLIPBOARD = 777; public static final int WM_VSCROLLCLIPBOARD = 778; public static final int WM_SIZECLIPBOARD = 779; public static final int WM_ASKCBFORMATNAME = 780; public static final int WM_CHANGECBCHAIN = 781; public static final int WM_HSCROLLCLIPBOARD = 782; public static final int WM_QUERYNEWPALETTE = 783; public static final int WM_PALETTEISCHANGING = 784; public static final int WM_PALETTECHANGED = 785; public static final int WM_HOTKEY = 786; public static final int WM_PRINT = 791; public static final int WM_PRINTCLIENT = 792; public static final int WM_APPCOMMAND = 793; public static final int WM_THEMECHANGED = 794; public static final int WM_CLIPBOARDUPDATE = 797; public static final int WM_DWMCOMPOSITIONCHANGED = 798; public static final int WM_DWMNCRENDERINGCHANGED = 799; public static final int WM_DWMCOLORIZATIONCOLORCHANGED = 800; public static final int WM_DWMWINDOWMAXIMIZEDCHANGE = 801; public static final int WM_DWMSENDICONICTHUMBNAIL = 803; public static final int WM_DWMSENDICONICLIVEPREVIEWBITMAP = 806; public static final int WM_GETTITLEBARINFOEX = 831; public static final int WM_HANDHELDFIRST = 856; public static final int WM_HANDHELDLAST = 863; public static final int WM_AFXFIRST = 864; public static final int WM_AFXLAST = 895; public static final int WM_PENWINFIRST = 896; public static final int WM_PENWINLAST = 911; public static final int WM_APP = 32768; public static final int WM_USER = 1024; public static final int WA_ACTIVE = 1; public static final int WA_CLICKACTIVE = 2; public static final int WA_INACTIVE = 0; public static final int SIZE_RESTORED = 0; public static final int SIZE_MINIMIZED = 1; public static final int SIZE_MAXIMIZED = 2; public static final int SIZE_MAXSHOW = 3; public static final int SIZE_MAXHIDE = 4; public static final int DBT_APPYBEGIN = 0; public static final int DBT_APPYEND = 1; public static final int DBT_DEVNODES_CHANGED = 7; public static final int DBT_QUERYCHANGECONFIG = 23; public static final int DBT_CONFIGCHANGED = 24; public static final int DBT_CONFIGCHANGECANCELED = 25; public static final int DBT_MONITORCHANGE = 27; public static final int SC_SIZE = 61440; public static final int SC_MOVE = 61456; public static final int SC_MINIMIZE = 61472; public static final int SC_MAXIMIZE = 61488; public static final int SC_NEXTWINDOW = 61504; public static final int SC_PREVWINDOW = 61520; public static final int SC_CLOSE = 61536; public static final int SC_VSCROLL = 61552; public static final int SC_HSCROLL = 61568; public static final int SC_MOUSEMENU = 61584; public static final int SC_KEYMENU = 61696; public static final int SC_ARRANGE = 61712; public static final int SC_RESTORE = 61728; public static final int SC_TASKLIST = 61744; public static final int SC_SCREENSAVE = 61760; public static final int SC_HOTKEY = 61776; public static final int SC_DEFAULT = 61792; public static final int SC_MONITORPOWER = 61808; public static final int SC_CONTEXTHELP = 61824; public static final int SC_SEPARATOR = 61455; public static final int MK_LBUTTON = 1; public static final int MK_RBUTTON = 2; public static final int MK_SHIFT = 4; public static final int MK_CONTROL = 8; public static final int MK_MBUTTON = 16; public static final int MK_XBUTTON1 = 32; public static final int MK_XBUTTON2 = 64; public static final int HTERROR = -2; public static final int HTTRANSPARENT = -1; public static final int HTNOWHERE = 0; public static final int HTCLIENT = 1; public static final int HTCAPTION = 2; public static final int HTSYSMENU = 3; public static final int HTGROWBOX = 4; public static final int HTSIZE = 4; public static final int HTMENU = 5; public static final int HTHSCROLL = 6; public static final int HTVSCROLL = 7; public static final int HTMINBUTTON = 8; public static final int HTMAXBUTTON = 9; public static final int HTLEFT = 10; public static final int HTRIGHT = 11; public static final int HTTOP = 12; public static final int HTTOPLEFT = 13; public static final int HTTOPRIGHT = 14; public static final int HTBOTTOM = 15; public static final int HTBOTTOMLEFT = 16; public static final int HTBOTTOMRIGHT = 17; public static final int HTBORDER = 18; public static final int HTREDUCE = 8; public static final int HTZOOM = 9; public static final int HTSIZEFIRST = 10; public static final int HTSIZELAST = 17; public static final int HTOBJECT = 19; public static final int HTCLOSE = 20; public static final int HTHELP = 21; public static final int GWL_WNDPROC = -4; public static final int GWL_HINSTANCE = -6; public static final int GWL_HWNDPARENT = -8; public static final int GWL_STYLE = -16; public static final int GWL_EXSTYLE = -20; public static final int GWL_USERDATA = -21; public static final int GWL_ID = -12; public static final int SW_HIDE = 0; public static final int SW_SHOWNORMAL = 1; public static final int SW_NORMAL = 1; public static final int SW_SHOWMINIMIZED = 2; public static final int SW_SHOWMAXIMIZED = 3; public static final int SW_MAXIMIZE = 3; public static final int SW_SHOWNOACTIVATE = 4; public static final int SW_SHOW = 5; public static final int SW_MINIMIZE = 6; public static final int SW_SHOWMINNOACTIVE = 7; public static final int SW_SHOWNA = 8; public static final int SW_RESTORE = 9; public static final int SW_SHOWDEFAULT = 10; public static final int SW_FORCEMINIMIZE = 11; public static final int SW_MAX = 11; public static final long HWND_TOP = 0L; public static final long HWND_BOTTOM = 1L; public static final long HWND_TOPMOST = -1L; public static final long HWND_NOTOPMOST = -2L; public static final long HWND_BROADCAST = 65535L; public static final int SWP_NOSIZE = 1; public static final int SWP_NOMOVE = 2; public static final int SWP_NOZORDER = 4; public static final int SWP_NOREDRAW = 8; public static final int SWP_NOACTIVATE = 16; public static final int SWP_FRAMECHANGED = 32; public static final int SWP_SHOWWINDOW = 64; public static final int SWP_HIDEWINDOW = 128; public static final int SWP_NOCOPYBITS = 256; public static final int SWP_NOOWNERZORDER = 512; public static final int SWP_NOSENDCHANGING = 1024; public static final int SWP_DRAWFRAME = 32; public static final int SWP_NOREPOSITION = 512; public static final int SWP_DEFERERASE = 8192; public static final int SWP_ASYNCWINDOWPOS = 16384; public static final int IDI_APPLICATION = 32512; public static final int IDI_HAND = 32513; public static final int IDI_QUESTION = 32514; public static final int IDI_EXCLAMATION = 32515; public static final int IDI_ASTERISK = 32516; public static final int IDI_WINLOGO = 32517; public static final int IDI_SHIELD = 32518; public static final int IDI_WARNING = 32515; public static final int IDI_ERROR = 32513; public static final int IDI_INFORMATION = 32516; public static final int IDC_ARROW = 32512; public static final int IDC_IBEAM = 32513; public static final int IDC_WAIT = 32514; public static final int IDC_CROSS = 32515; public static final int IDC_UPARROW = 32516; public static final int IDC_SIZE = 32640; public static final int IDC_ICON = 32641; public static final int IDC_SIZENWSE = 32642; public static final int IDC_SIZENESW = 32643; public static final int IDC_SIZEWE = 32644; public static final int IDC_SIZENS = 32645; public static final int IDC_SIZEALL = 32646; public static final int IDC_NO = 32648; public static final int IDC_HAND = 32649; public static final int IDC_APPSTARTING = 32650; public static final int IDC_HELP = 32651; public static final int GCL_MENUNAME = -8; public static final int GCL_HBRBACKGROUND = -10; public static final int GCL_HCURSOR = -12; public static final int GCL_HICON = -14; public static final int GCL_HMODULE = -16; public static final int GCL_CBWNDEXTRA = -18; public static final int GCL_CBCLSEXTRA = -20; public static final int GCL_WNDPROC = -24; public static final int GCL_STYLE = -26; public static final int GCW_ATOM = -32; public static final int GCL_HICONSM = -34; public static final int QS_KEY = 1; public static final int QS_MOUSEMOVE = 2; public static final int QS_MOUSEBUTTON = 4; public static final int QS_POSTMESSAGE = 8; public static final int QS_TIMER = 16; public static final int QS_PAINT = 32; public static final int QS_SENDMESSAGE = 64; public static final int QS_HOTKEY = 128; public static final int QS_ALLPOSTMESSAGE = 256; public static final int QS_RAWINPUT = 1024; public static final int QS_MOUSE = 6; public static final int QS_INPUT = 7; public static final int QS_ALLEVENTS = 191; public static final int QS_ALLINPUT = 255; public static final int PM_NOREMOVE = 0; public static final int PM_REMOVE = 1; public static final int PM_NOYIELD = 2; public static final int PM_QS_INPUT = 458752; public static final int PM_QS_POSTMESSAGE = 9961472; public static final int PM_QS_PAINT = 2097152; public static final int PM_QS_SENDMESSAGE = 4194304; public static final int VK_LBUTTON = 1; public static final int VK_RBUTTON = 2; public static final int VK_CANCEL = 3; public static final int VK_MBUTTON = 4; public static final int VK_XBUTTON1 = 5; public static final int VK_XBUTTON2 = 6; public static final int VK_BACK = 8; public static final int VK_TAB = 9; public static final int VK_CLEAR = 12; public static final int VK_RETURN = 13; public static final int VK_SHIFT = 16; public static final int VK_CONTROL = 17; public static final int VK_MENU = 18; public static final int VK_PAUSE = 19; public static final int VK_CAPITAL = 20; public static final int VK_KANA = 21; public static final int VK_HANGEUL = 21; public static final int VK_HANGUL = 21; public static final int VK_JUNJA = 23; public static final int VK_FINAL = 24; public static final int VK_HANJA = 25; public static final int VK_KANJI = 25; public static final int VK_ESCAPE = 27; public static final int VK_CONVERT = 28; public static final int VK_NONCONVERT = 29; public static final int VK_ACCEPT = 30; public static final int VK_MODECHANGE = 31; public static final int VK_SPACE = 32; public static final int VK_PRIOR = 33; public static final int VK_NEXT = 34; public static final int VK_END = 35; public static final int VK_HOME = 36; public static final int VK_LEFT = 37; public static final int VK_UP = 38; public static final int VK_RIGHT = 39; public static final int VK_DOWN = 40; public static final int VK_SELECT = 41; public static final int VK_PRINT = 42; public static final int VK_EXECUTE = 43; public static final int VK_SNAPSHOT = 44; public static final int VK_INSERT = 45; public static final int VK_DELETE = 46; public static final int VK_HELP = 47; public static final int VK_LWIN = 91; public static final int VK_RWIN = 92; public static final int VK_APPS = 93; public static final int VK_SLEEP = 95; public static final int VK_NUMPAD0 = 96; public static final int VK_NUMPAD1 = 97; public static final int VK_NUMPAD2 = 98; public static final int VK_NUMPAD3 = 99; public static final int VK_NUMPAD4 = 100; public static final int VK_NUMPAD5 = 101; public static final int VK_NUMPAD6 = 102; public static final int VK_NUMPAD7 = 103; public static final int VK_NUMPAD8 = 104; public static final int VK_NUMPAD9 = 105; public static final int VK_MULTIPLY = 106; public static final int VK_ADD = 107; public static final int VK_SEPARATOR = 108; public static final int VK_SUBTRACT = 109; public static final int VK_DECIMAL = 110; public static final int VK_DIVIDE = 111; public static final int VK_F1 = 112; public static final int VK_F2 = 113; public static final int VK_F3 = 114; public static final int VK_F4 = 115; public static final int VK_F5 = 116; public static final int VK_F6 = 117; public static final int VK_F7 = 118; public static final int VK_F8 = 119; public static final int VK_F9 = 120; public static final int VK_F10 = 121; public static final int VK_F11 = 122; public static final int VK_F12 = 123; public static final int VK_F13 = 124; public static final int VK_F14 = 125; public static final int VK_F15 = 126; public static final int VK_F16 = 127; public static final int VK_F17 = 128; public static final int VK_F18 = 129; public static final int VK_F19 = 130; public static final int VK_F20 = 131; public static final int VK_F21 = 132; public static final int VK_F22 = 133; public static final int VK_F23 = 134; public static final int VK_F24 = 135; public static final int VK_NUMLOCK = 144; public static final int VK_SCROLL = 145; public static final int VK_OEM_NEC_EQUAL = 146; public static final int VK_OEM_FJ_JISHO = 146; public static final int VK_OEM_FJ_MASSHOU = 147; public static final int VK_OEM_FJ_TOUROKU = 148; public static final int VK_OEM_FJ_LOYA = 149; public static final int VK_OEM_FJ_ROYA = 150; public static final int VK_LSHIFT = 160; public static final int VK_RSHIFT = 161; public static final int VK_LCONTROL = 162; public static final int VK_RCONTROL = 163; public static final int VK_LMENU = 164; public static final int VK_RMENU = 165; public static final int VK_BROWSER_BACK = 166; public static final int VK_BROWSER_FORWARD = 167; public static final int VK_BROWSER_REFRESH = 168; public static final int VK_BROWSER_STOP = 169; public static final int VK_BROWSER_SEARCH = 170; public static final int VK_BROWSER_FAVORITES = 171; public static final int VK_BROWSER_HOME = 172; public static final int VK_VOLUME_MUTE = 173; public static final int VK_VOLUME_DOWN = 174; public static final int VK_VOLUME_UP = 175; public static final int VK_MEDIA_NEXT_TRACK = 176; public static final int VK_MEDIA_PREV_TRACK = 177; public static final int VK_MEDIA_STOP = 178; public static final int VK_MEDIA_PLAY_PAUSE = 179; public static final int VK_LAUNCH_MAIL = 180; public static final int VK_LAUNCH_MEDIA_SELECT = 181; public static final int VK_LAUNCH_APP1 = 182; public static final int VK_LAUNCH_APP2 = 183; public static final int VK_OEM_1 = 186; public static final int VK_OEM_PLUS = 187; public static final int VK_OEM_COMMA = 188; public static final int VK_OEM_MINUS = 189; public static final int VK_OEM_PERIOD = 190; public static final int VK_OEM_2 = 191; public static final int VK_OEM_3 = 192; public static final int VK_OEM_4 = 219; public static final int VK_OEM_5 = 220; public static final int VK_OEM_6 = 221; public static final int VK_OEM_7 = 222; public static final int VK_OEM_8 = 223; public static final int VK_OEM_AX = 225; public static final int VK_OEM_102 = 226; public static final int VK_ICO_HELP = 227; public static final int VK_ICO_00 = 228; public static final int VK_PROCESSKEY = 229; public static final int VK_ICO_CLEAR = 230; public static final int VK_PACKET = 231; public static final int VK_OEM_RESET = 233; public static final int VK_OEM_JUMP = 234; public static final int VK_OEM_PA1 = 235; public static final int VK_OEM_PA2 = 236; public static final int VK_OEM_PA3 = 237; public static final int VK_OEM_WSCTRL = 238; public static final int VK_OEM_CUSEL = 239; public static final int VK_OEM_ATTN = 240; public static final int VK_OEM_FINISH = 241; public static final int VK_OEM_COPY = 242; public static final int VK_OEM_AUTO = 243; public static final int VK_OEM_ENLW = 244; public static final int VK_OEM_BACKTAB = 245; public static final int VK_ATTN = 246; public static final int VK_CRSEL = 247; public static final int VK_EXSEL = 248; public static final int VK_EREOF = 249; public static final int VK_PLAY = 250; public static final int VK_ZOOM = 251; public static final int VK_NONAME = 252; public static final int VK_PA1 = 253; public static final int VK_OEM_CLEAR = 254; public static final int XBUTTON1 = 1; public static final int XBUTTON2 = 2; public static final int WHEEL_DELTA = 120; public static final int DPI_AWARENESS_INVALID = -1; public static final int DPI_AWARENESS_UNAWARE = 0; public static final int DPI_AWARENESS_SYSTEM_AWARE = 1; public static final int DPI_AWARENESS_PER_MONITOR_AWARE = 2; public static final long DPI_AWARENESS_CONTEXT_UNAWARE = -1L; public static final long DPI_AWARENESS_CONTEXT_SYSTEM_AWARE = -2L; public static final long DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE = -3L; public static final long DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2 = -4L; public static final int WPF_SETMINPOSITION = 1; public static final int WPF_RESTORETOMAXIMIZED = 2; public static final int WPF_ASYNCWINDOWPLACEMENT = 4; public static final int LWA_COLORKEY = 1; public static final int LWA_ALPHA = 2; public static final int SM_CXSCREEN = 0; public static final int SM_CYSCREEN = 1; public static final int SM_CXVSCROLL = 2; public static final int SM_CYHSCROLL = 3; public static final int SM_CYCAPTION = 4; public static final int SM_CXBORDER = 5; public static final int SM_CYBORDER = 6; public static final int SM_CXDLGFRAME = 7; public static final int SM_CYDLGFRAME = 8; public static final int SM_CYVTHUMB = 9; public static final int SM_CXHTHUMB = 10; public static final int SM_CXICON = 11; public static final int SM_CYICON = 12; public static final int SM_CXCURSOR = 13; public static final int SM_CYCURSOR = 14; public static final int SM_CYMENU = 15; public static final int SM_CXFULLSCREEN = 16; public static final int SM_CYFULLSCREEN = 17; public static final int SM_CYKANJIWINDOW = 18; public static final int SM_MOUSEPRESENT = 19; public static final int SM_CYVSCROLL = 20; public static final int SM_CXHSCROLL = 21; public static final int SM_DEBUG = 22; public static final int SM_SWAPBUTTON = 23; public static final int SM_RESERVED1 = 24; public static final int SM_RESERVED2 = 25; public static final int SM_RESERVED3 = 26; public static final int SM_RESERVED4 = 27; public static final int SM_CXMIN = 28; public static final int SM_CYMIN = 29; public static final int SM_CXSIZE = 30; public static final int SM_CYSIZE = 31; public static final int SM_CXFRAME = 32; public static final int SM_CYFRAME = 33; public static final int SM_CXMINTRACK = 34; public static final int SM_CYMINTRACK = 35; public static final int SM_CXDOUBLECLK = 36; public static final int SM_CYDOUBLECLK = 37; public static final int SM_CXICONSPACING = 38; public static final int SM_CYICONSPACING = 39; public static final int SM_MENUDROPALIGNMENT = 40; public static final int SM_PENWINDOWS = 41; public static final int SM_DBCSENABLED = 42; public static final int SM_CMOUSEBUTTONS = 43; public static final int SM_CXFIXEDFRAME = 7; public static final int SM_CYFIXEDFRAME = 8; public static final int SM_CXSIZEFRAME = 32; public static final int SM_CYSIZEFRAME = 33; public static final int SM_SECURE = 44; public static final int SM_CXEDGE = 45; public static final int SM_CYEDGE = 46; public static final int SM_CXMINSPACING = 47; public static final int SM_CYMINSPACING = 48; public static final int SM_CXSMICON = 49; public static final int SM_CYSMICON = 50; public static final int SM_CYSMCAPTION = 51; public static final int SM_CXSMSIZE = 52; public static final int SM_CYSMSIZE = 53; public static final int SM_CXMENUSIZE = 54; public static final int SM_CYMENUSIZE = 55; public static final int SM_ARRANGE = 56; public static final int SM_CXMINIMIZED = 57; public static final int SM_CYMINIMIZED = 58; public static final int SM_CXMAXTRACK = 59; public static final int SM_CYMAXTRACK = 60; public static final int SM_CXMAXIMIZED = 61; public static final int SM_CYMAXIMIZED = 62; public static final int SM_NETWORK = 63; public static final int SM_CLEANBOOT = 67; public static final int SM_CXDRAG = 68; public static final int SM_CYDRAG = 69; public static final int SM_SHOWSOUNDS = 70; public static final int SM_CXMENUCHECK = 71; public static final int SM_CYMENUCHECK = 72; public static final int SM_SLOWMACHINE = 73; public static final int SM_MIDEASTENABLED = 74; public static final int SM_MOUSEWHEELPRESENT = 75; public static final int SM_XVIRTUALSCREEN = 76; public static final int SM_YVIRTUALSCREEN = 77; public static final int SM_CXVIRTUALSCREEN = 78; public static final int SM_CYVIRTUALSCREEN = 79; public static final int SM_CMONITORS = 80; public static final int SM_SAMEDISPLAYFORMAT = 81; public static final int SM_IMMENABLED = 82; public static final int SM_REMOTESESSION = 4096; public static final int SM_SHUTTINGDOWN = 8192; public static final int SM_REMOTECONTROL = 8193; public static final int SM_CARETBLINKINGENABLED = 8194; public static final int SM_CXFOCUSBORDER = 83; public static final int SM_CYFOCUSBORDER = 84; public static final int SM_TABLETPC = 86; public static final int SM_MEDIACENTER = 87; public static final int SM_STARTER = 88; public static final int SM_SERVERR2 = 89; public static final int SM_MOUSEHORIZONTALWHEELPRESENT = 91; public static final int SM_CXPADDEDBORDER = 92; public static final int SM_DIGITIZER = 94; public static final int SM_MAXIMUMTOUCHES = 95; public static final int TWF_FINETOUCH = 1; public static final int TWF_WANTPALM = 2; public static final int TOUCHEVENTF_MOVE = 1; public static final int TOUCHEVENTF_DOWN = 2; public static final int TOUCHEVENTF_UP = 4; public static final int TOUCHEVENTF_INRANGE = 8; public static final int TOUCHEVENTF_PRIMARY = 16; public static final int TOUCHEVENTF_NOCOALESCE = 32; public static final int TOUCHEVENTF_PEN = 64; public static final int TOUCHEVENTF_PALM = 128; public static final int TOUCHINPUTMASKF_TIMEFROMSYSTEM = 1; public static final int TOUCHINPUTMASKF_EXTRAINFO = 2; public static final int TOUCHINPUTMASKF_CONTACTAREA = 4; public static final int MONITOR_DEFAULTTONULL = 0; public static final int MONITOR_DEFAULTTOPRIMARY = 1; public static final int MONITOR_DEFAULTTONEAREST = 2; public static final int MONITORINFOF_PRIMARY = 1; public static final int EDD_GET_DEVICE_INTERFACE_NAME = 1; public static final int ENUM_CURRENT_SETTINGS = -1; public static final int ENUM_REGISTRY_SETTINGS = -2; public static final int EDS_RAWMODE = 2; public static final int EDS_ROTATEDMODE = 4; public static final int CDS_UPDATEREGISTRY = 1; public static final int CDS_TEST = 2; public static final int CDS_FULLSCREEN = 4; public static final int CDS_GLOBAL = 8; public static final int CDS_SET_PRIMARY = 16; public static final int CDS_VIDEOPARAMETERS = 32; public static final int CDS_ENABLE_UNSAFE_MODES = 256; public static final int CDS_DISABLE_UNSAFE_MODES = 512; public static final int CDS_RESET = 1073741824; public static final int CDS_RESET_EX = 536870912; public static final int CDS_NORESET = 268435456; public static final int DISP_CHANGE_SUCCESSFUL = 0; public static final int DISP_CHANGE_RESTART = 1; public static final int DISP_CHANGE_FAILED = -1; public static final int DISP_CHANGE_BADMODE = -2; public static final int DISP_CHANGE_NOTUPDATED = -3; public static final int DISP_CHANGE_BADFLAGS = -4; public static final int DISP_CHANGE_BADPARAM = -5; public static final int DISP_CHANGE_BADDUALVIEW = -6; public static final int INPUT_MOUSE = 0; public static final int INPUT_KEYBOARD = 1; public static final int INPUT_HARDWARE = 2; public static final int MOUSEEVENTF_ABSOLUTE = 32768; public static final int MOUSEEVENTF_HWHEEL = 4096; public static final int MOUSEEVENTF_MOVE = 1; public static final int MOUSEEVENTF_MOVE_NOCOALESCE = 8192; public static final int MOUSEEVENTF_LEFTDOWN = 2; public static final int MOUSEEVENTF_LEFTUP = 4; public static final int MOUSEEVENTF_RIGHTDOWN = 8; public static final int MOUSEEVENTF_RIGHTUP = 16; public static final int MOUSEEVENTF_MIDDLEDOWN = 32; public static final int MOUSEEVENTF_MIDDLEUP = 64; public static final int MOUSEEVENTF_VIRTUALDESK = 16384;
/*      */   public static final int MOUSEEVENTF_WHEEL = 2048;
/*      */   public static final int MOUSEEVENTF_XDOWN = 128;
/*      */   public static final int MOUSEEVENTF_XUP = 256;
/*      */   public static final int KEYEVENTF_EXTENDEDKEY = 1;
/*      */   public static final int KEYEVENTF_KEYUP = 2;
/*      */   public static final int KEYEVENTF_SCANCODE = 8;
/*      */   public static final int KEYEVENTF_UNICODE = 4;
/*      */   
/*   32 */   public static final class Functions { public static final long RegisterClassEx = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "RegisterClassExW");
/*   33 */     public static final long UnregisterClass = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "UnregisterClassW");
/*   34 */     public static final long CreateWindowEx = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "CreateWindowExW");
/*   35 */     public static final long DestroyWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "DestroyWindow");
/*   36 */     public static final long DefWindowProc = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "DefWindowProcW");
/*   37 */     public static final long CallWindowProc = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "CallWindowProcW");
/*   38 */     public static final long ShowWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ShowWindow");
/*   39 */     public static final long UpdateWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "UpdateWindow");
/*   40 */     public static final long SetWindowPos = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetWindowPos");
/*   41 */     public static final long SetWindowText = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetWindowTextW");
/*   42 */     public static final long GetMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetMessageW");
/*   43 */     public static final long PeekMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "PeekMessageW");
/*   44 */     public static final long TranslateMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "TranslateMessage");
/*   45 */     public static final long WaitMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "WaitMessage");
/*   46 */     public static final long DispatchMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "DispatchMessageW");
/*   47 */     public static final long PostMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "PostMessageW");
/*   48 */     public static final long SendMessage = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SendMessageW");
/*   49 */     public static final long AdjustWindowRectEx = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "AdjustWindowRectEx");
/*   50 */     public static final long GetWindowRect = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetWindowRect");
/*   51 */     public static final long MoveWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "MoveWindow");
/*   52 */     public static final long GetWindowPlacement = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetWindowPlacement");
/*   53 */     public static final long SetWindowPlacement = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetWindowPlacement");
/*   54 */     public static final long IsWindowVisible = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "IsWindowVisible");
/*   55 */     public static final long IsIconic = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "IsIconic");
/*   56 */     public static final long IsZoomed = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "IsZoomed");
/*   57 */     public static final long BringWindowToTop = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "BringWindowToTop");
/*   58 */     public static final long SetWindowLongPtr = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, Pointer.BITS64 ? "SetWindowLongPtrW" : "SetWindowLongW");
/*   59 */     public static final long GetWindowLongPtr = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, Pointer.BITS64 ? "GetWindowLongPtrW" : "GetWindowLongW");
/*   60 */     public static final long SetClassLongPtr = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, Pointer.BITS64 ? "SetClassLongPtrW" : "SetClassLongW");
/*   61 */     public static final long GetClassLongPtr = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, Pointer.BITS64 ? "GetClassLongPtrW" : "GetClassLongW");
/*   62 */     public static final long SetLayeredWindowAttributes = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetLayeredWindowAttributes");
/*   63 */     public static final long LoadIcon = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "LoadIconW");
/*   64 */     public static final long LoadCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "LoadCursorW");
/*   65 */     public static final long GetDC = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetDC");
/*   66 */     public static final long ReleaseDC = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ReleaseDC");
/*   67 */     public static final long GetSystemMetrics = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetSystemMetrics");
/*   68 */     public static final long RegisterTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "RegisterTouchWindow");
/*   69 */     public static final long UnregisterTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "UnregisterTouchWindow");
/*   70 */     public static final long IsTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "IsTouchWindow");
/*   71 */     public static final long GetTouchInputInfo = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetTouchInputInfo");
/*   72 */     public static final long CloseTouchInputHandle = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "CloseTouchInputHandle");
/*   73 */     public static final long MonitorFromWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "MonitorFromWindow");
/*   74 */     public static final long GetMonitorInfo = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetMonitorInfoW");
/*   75 */     public static final long EnumDisplayDevices = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "EnumDisplayDevicesW");
/*   76 */     public static final long EnumDisplaySettingsEx = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "EnumDisplaySettingsExW");
/*   77 */     public static final long ChangeDisplaySettingsEx = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ChangeDisplaySettingsExW");
/*   78 */     public static final long GetCursorPos = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetCursorPos");
/*   79 */     public static final long SetCursorPos = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetCursorPos");
/*   80 */     public static final long ClipCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ClipCursor");
/*   81 */     public static final long ShowCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ShowCursor");
/*   82 */     public static final long SetCursor = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SetCursor");
/*   83 */     public static final long ClientToScreen = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "ClientToScreen");
/*   84 */     public static final long GetAsyncKeyState = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetAsyncKeyState");
/*   85 */     public static final long GetMessageExtraInfo = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "GetMessageExtraInfo");
/*   86 */     public static final long SendInput = APIUtil.apiGetFunctionAddress((FunctionProvider)User32.USER32, "SendInput");
/*   87 */     public static final long GetDpiForSystem = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetDpiForSystem");
/*   88 */     public static final long GetDpiForWindow = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetDpiForWindow");
/*   89 */     public static final long GetAwarenessFromDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetAwarenessFromDpiAwarenessContext");
/*   90 */     public static final long GetThreadDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetThreadDpiAwarenessContext");
/*   91 */     public static final long GetWindowDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "GetWindowDpiAwarenessContext");
/*   92 */     public static final long IsValidDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "IsValidDpiAwarenessContext");
/*   93 */     public static final long SetThreadDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.USER32, "SetThreadDpiAwarenessContext"); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static SharedLibrary getLibrary() {
/*   99 */     return USER32;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected User32() {
/* 1105 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short nRegisterClassEx(long paramLong) {
/* 1115 */     long l = Functions.RegisterClassEx;
/* 1116 */     if (Checks.CHECKS) {
/* 1117 */       WNDCLASSEX.validate(paramLong);
/*      */     }
/* 1119 */     return nRegisterClassEx(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ATOM")
/*      */   public static short RegisterClassEx(@NativeType("WNDCLASSEX const *") WNDCLASSEX paramWNDCLASSEX) {
/* 1129 */     return nRegisterClassEx(paramWNDCLASSEX.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nUnregisterClass(long paramLong1, long paramLong2) {
/* 1139 */     long l = Functions.UnregisterClass;
/* 1140 */     return nUnregisterClass(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean UnregisterClass(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer, @NativeType("HINSTANCE") long paramLong) {
/* 1154 */     if (Checks.CHECKS) {
/* 1155 */       Checks.checkNT2(paramByteBuffer);
/*      */     }
/* 1157 */     return (nUnregisterClass(MemoryUtil.memAddress(paramByteBuffer), paramLong) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean UnregisterClass(@NativeType("LPCTSTR") CharSequence paramCharSequence, @NativeType("HINSTANCE") long paramLong) {
/*      */     MemoryStack memoryStack;
/* 1171 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1173 */       memoryStack.nUTF16(paramCharSequence, true); long l; return 
/*      */         
/* 1175 */         (nUnregisterClass(l = memoryStack.getPointerAddress(), paramLong) != 0);
/*      */     } finally {
/* 1177 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nCreateWindowEx(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/* 1188 */     long l = Functions.CreateWindowEx;
/* 1189 */     return nCreateWindowEx(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong3, paramLong4, paramLong5, paramLong6, l);
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
/*      */   @NativeType("HWND")
/*      */   public static long CreateWindowEx(@NativeType("DWORD") int paramInt1, @NativeType("LPCTSTR") ByteBuffer paramByteBuffer1, @NativeType("LPCTSTR") ByteBuffer paramByteBuffer2, @NativeType("DWORD") int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @NativeType("HWND") long paramLong1, @NativeType("HMENU") long paramLong2, @NativeType("HINSTANCE") long paramLong3, @NativeType("LPVOID") long paramLong4) {
/* 1211 */     if (Checks.CHECKS) {
/* 1212 */       Checks.checkNT2Safe(paramByteBuffer1);
/* 1213 */       Checks.checkNT2Safe(paramByteBuffer2);
/*      */     } 
/* 1215 */     return nCreateWindowEx(paramInt1, MemoryUtil.memAddressSafe(paramByteBuffer1), MemoryUtil.memAddressSafe(paramByteBuffer2), paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramLong3, paramLong4);
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
/*      */   @NativeType("HWND")
/*      */   public static long CreateWindowEx(@NativeType("DWORD") int paramInt1, @NativeType("LPCTSTR") CharSequence paramCharSequence1, @NativeType("LPCTSTR") CharSequence paramCharSequence2, @NativeType("DWORD") int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @NativeType("HWND") long paramLong1, @NativeType("HMENU") long paramLong2, @NativeType("HINSTANCE") long paramLong3, @NativeType("LPVOID") long paramLong4) {
/*      */     MemoryStack memoryStack;
/* 1237 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1239 */       memoryStack.nUTF16Safe(paramCharSequence1, true);
/* 1240 */       long l1 = (paramCharSequence1 == null) ? 0L : memoryStack.getPointerAddress();
/* 1241 */       memoryStack.nUTF16Safe(paramCharSequence2, true);
/* 1242 */       long l2 = (paramCharSequence2 == null) ? 0L : memoryStack.getPointerAddress();
/* 1243 */       return nCreateWindowEx(paramInt1, l1, l2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramLong3, paramLong4);
/*      */     } finally {
/* 1245 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean DestroyWindow(@NativeType("HWND") long paramLong) {
/* 1266 */     long l = Functions.DestroyWindow;
/* 1267 */     if (Checks.CHECKS) {
/* 1268 */       Checks.check(paramLong);
/*      */     }
/* 1270 */     return (nDestroyWindow(paramLong, l) != 0);
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
/*      */   @NativeType("LRESULT")
/*      */   public static long DefWindowProc(@NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3) {
/* 1286 */     long l = Functions.DefWindowProc;
/* 1287 */     if (Checks.CHECKS) {
/* 1288 */       Checks.check(paramLong1);
/*      */     }
/* 1290 */     return JNI.callPPPP(paramLong1, paramInt, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nCallWindowProc(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4) {
/* 1297 */     long l = Functions.CallWindowProc;
/* 1298 */     if (Checks.CHECKS) {
/* 1299 */       Checks.check(paramLong2);
/*      */     }
/* 1301 */     return JNI.callPPPPP(paramLong1, paramLong2, paramInt, paramLong3, paramLong4, l);
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
/*      */   @NativeType("LRESULT")
/*      */   public static long CallWindowProc(@NativeType("WNDPROC") WindowProcI paramWindowProcI, @NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3) {
/* 1318 */     return nCallWindowProc(paramWindowProcI.address(), paramLong1, paramInt, paramLong2, paramLong3);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean ShowWindow(@NativeType("HWND") long paramLong, int paramInt) {
/* 1333 */     long l = Functions.ShowWindow;
/* 1334 */     if (Checks.CHECKS) {
/* 1335 */       Checks.check(paramLong);
/*      */     }
/* 1337 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean UpdateWindow(@NativeType("HWND") long paramLong) {
/* 1351 */     long l = Functions.UpdateWindow;
/* 1352 */     if (Checks.CHECKS) {
/* 1353 */       Checks.check(paramLong);
/*      */     }
/* 1355 */     return (JNI.callPI(paramLong, l) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetWindowPos(@NativeType("HWND") long paramLong1, @NativeType("HWND") long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NativeType("UINT") int paramInt5) {
/* 1377 */     long l = Functions.SetWindowPos;
/* 1378 */     if (Checks.CHECKS) {
/* 1379 */       Checks.check(paramLong1);
/*      */     }
/* 1381 */     return (nSetWindowPos(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nSetWindowText(long paramLong1, long paramLong2) {
/* 1391 */     long l = Functions.SetWindowText;
/* 1392 */     if (Checks.CHECKS) {
/* 1393 */       Checks.check(paramLong1);
/*      */     }
/* 1395 */     return nSetWindowText(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetWindowText(@NativeType("HWND") long paramLong, @NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 1407 */     if (Checks.CHECKS) {
/* 1408 */       Checks.checkNT2(paramByteBuffer);
/*      */     }
/* 1410 */     return (nSetWindowText(paramLong, MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetWindowText(@NativeType("HWND") long paramLong, @NativeType("LPCTSTR") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1422 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1424 */       memoryStack.nUTF16(paramCharSequence, true);
/* 1425 */       long l = memoryStack.getPointerAddress();
/* 1426 */       return (nSetWindowText(paramLong, l) != 0);
/*      */     } finally {
/* 1428 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nGetMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
/* 1439 */     long l = Functions.GetMessage;
/* 1440 */     return nGetMessage(paramLong1, paramLong2, paramInt1, paramInt2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetMessage(@NativeType("LPMSG") MSG paramMSG, @NativeType("HWND") long paramLong, @NativeType("UINT") int paramInt1, @NativeType("UINT") int paramInt2) {
/* 1461 */     return (nGetMessage(paramMSG.address(), paramLong, paramInt1, paramInt2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nPeekMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3) {
/* 1468 */     long l = Functions.PeekMessage;
/* 1469 */     return JNI.callPPI(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean PeekMessage(@NativeType("LPMSG") MSG paramMSG, @NativeType("HWND") long paramLong, @NativeType("UINT") int paramInt1, @NativeType("UINT") int paramInt2, @NativeType("UINT") int paramInt3) {
/* 1490 */     return (nPeekMessage(paramMSG.address(), paramLong, paramInt1, paramInt2, paramInt3) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nTranslateMessage(long paramLong) {
/* 1497 */     long l = Functions.TranslateMessage;
/* 1498 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean TranslateMessage(@NativeType("MSG const *") MSG paramMSG) {
/* 1510 */     return (nTranslateMessage(paramMSG.address()) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean WaitMessage() {
/*      */     long l;
/* 1525 */     return (nWaitMessage(l = Functions.WaitMessage) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nDispatchMessage(long paramLong) {
/* 1532 */     long l = Functions.DispatchMessage;
/* 1533 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("LRESULT")
/*      */   public static long DispatchMessage(@NativeType("MSG const *") MSG paramMSG) {
/* 1543 */     return nDispatchMessage(paramMSG.address());
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean PostMessage(@NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3) {
/* 1568 */     long l = Functions.PostMessage;
/* 1569 */     return (nPostMessage(paramLong1, paramInt, paramLong2, paramLong3, l) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean SendMessage(@NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3) {
/* 1593 */     long l = Functions.SendMessage;
/* 1594 */     if (Checks.CHECKS) {
/* 1595 */       Checks.check(paramLong1);
/*      */     }
/* 1597 */     return (nSendMessage(paramLong1, paramInt, paramLong2, paramLong3, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nAdjustWindowRectEx(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 1607 */     long l = Functions.AdjustWindowRectEx;
/* 1608 */     return nAdjustWindowRectEx(paramLong, paramInt1, paramInt2, paramInt3, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean AdjustWindowRectEx(@NativeType("LPRECT") RECT paramRECT, @NativeType("DWORD") int paramInt1, @NativeType("BOOL") boolean paramBoolean, @NativeType("DWORD") int paramInt2) {
/* 1624 */     return (nAdjustWindowRectEx(paramRECT.address(), paramInt1, paramBoolean ? 1 : 0, paramInt2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nGetWindowRect(long paramLong1, long paramLong2) {
/* 1634 */     long l = Functions.GetWindowRect;
/* 1635 */     if (Checks.CHECKS) {
/* 1636 */       Checks.check(paramLong1);
/*      */     }
/* 1638 */     return nGetWindowRect(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetWindowRect(@NativeType("HWND") long paramLong, @NativeType("LPRECT") RECT paramRECT) {
/* 1650 */     return (nGetWindowRect(paramLong, paramRECT.address()) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean MoveWindow(@NativeType("HWND") long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NativeType("BOOL") boolean paramBoolean) {
/* 1673 */     long l = Functions.MoveWindow;
/* 1674 */     if (Checks.CHECKS) {
/* 1675 */       Checks.check(paramLong);
/*      */     }
/* 1677 */     return (nMoveWindow(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean ? 1 : 0, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nGetWindowPlacement(long paramLong1, long paramLong2) {
/* 1687 */     long l = Functions.GetWindowPlacement;
/* 1688 */     if (Checks.CHECKS) {
/* 1689 */       Checks.check(paramLong1);
/*      */     }
/* 1691 */     return nGetWindowPlacement(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetWindowPlacement(@NativeType("HWND") long paramLong, @NativeType("WINDOWPLACEMENT *") WINDOWPLACEMENT paramWINDOWPLACEMENT) {
/* 1705 */     return (nGetWindowPlacement(paramLong, paramWINDOWPLACEMENT.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nSetWindowPlacement(long paramLong1, long paramLong2) {
/* 1715 */     long l = Functions.SetWindowPlacement;
/* 1716 */     if (Checks.CHECKS) {
/* 1717 */       Checks.check(paramLong1);
/*      */     }
/* 1719 */     return nSetWindowPlacement(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetWindowPlacement(@NativeType("HWND") long paramLong, @NativeType("WINDOWPLACEMENT const *") WINDOWPLACEMENT paramWINDOWPLACEMENT) {
/* 1733 */     return (nSetWindowPlacement(paramLong, paramWINDOWPLACEMENT.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsWindowVisible(@NativeType("HWND") long paramLong) {
/* 1745 */     long l = Functions.IsWindowVisible;
/* 1746 */     if (Checks.CHECKS) {
/* 1747 */       Checks.check(paramLong);
/*      */     }
/* 1749 */     return (JNI.callPI(paramLong, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsIconic(@NativeType("HWND") long paramLong) {
/* 1761 */     long l = Functions.IsIconic;
/* 1762 */     if (Checks.CHECKS) {
/* 1763 */       Checks.check(paramLong);
/*      */     }
/* 1765 */     return (JNI.callPI(paramLong, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsZoomed(@NativeType("HWND") long paramLong) {
/* 1777 */     long l = Functions.IsZoomed;
/* 1778 */     if (Checks.CHECKS) {
/* 1779 */       Checks.check(paramLong);
/*      */     }
/* 1781 */     return (JNI.callPI(paramLong, l) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean BringWindowToTop(@NativeType("HWND") long paramLong) {
/* 1794 */     long l = Functions.BringWindowToTop;
/* 1795 */     if (Checks.CHECKS) {
/* 1796 */       Checks.check(paramLong);
/*      */     }
/* 1798 */     return (JNI.callPI(paramLong, l) != 0);
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
/*      */   @NativeType("LONG_PTR")
/*      */   public static long SetWindowLongPtr(@NativeType("HWND") long paramLong1, int paramInt, @NativeType("LONG_PTR") long paramLong2) {
/* 1818 */     long l = Functions.SetWindowLongPtr;
/* 1819 */     if (Checks.CHECKS) {
/* 1820 */       Checks.check(paramLong1);
/*      */     }
/* 1822 */     return nSetWindowLongPtr(paramLong1, paramInt, paramLong2, l);
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
/*      */   @NativeType("LONG_PTR")
/*      */   public static long GetWindowLongPtr(@NativeType("HWND") long paramLong, int paramInt) {
/* 1839 */     long l = Functions.GetWindowLongPtr;
/* 1840 */     if (Checks.CHECKS) {
/* 1841 */       Checks.check(paramLong);
/*      */     }
/* 1843 */     return nGetWindowLongPtr(paramLong, paramInt, l);
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
/*      */   @NativeType("LONG_PTR")
/*      */   public static long SetClassLongPtr(@NativeType("HWND") long paramLong1, int paramInt, @NativeType("LONG_PTR") long paramLong2) {
/* 1867 */     long l = Functions.SetClassLongPtr;
/* 1868 */     if (Checks.CHECKS) {
/* 1869 */       Checks.check(paramLong1);
/*      */     }
/* 1871 */     return nSetClassLongPtr(paramLong1, paramInt, paramLong2, l);
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
/*      */   @NativeType("LONG_PTR")
/*      */   public static long GetClassLongPtr(@NativeType("HWND") long paramLong, int paramInt) {
/* 1890 */     long l = Functions.GetClassLongPtr;
/* 1891 */     if (Checks.CHECKS) {
/* 1892 */       Checks.check(paramLong);
/*      */     }
/* 1894 */     return nGetClassLongPtr(paramLong, paramInt, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetLayeredWindowAttributes(@NativeType("HWND") long paramLong, @NativeType("COLORREF") int paramInt1, @NativeType("BYTE") byte paramByte, @NativeType("DWORD") int paramInt2) {
/* 1913 */     long l = Functions.SetLayeredWindowAttributes;
/* 1914 */     if (Checks.CHECKS) {
/* 1915 */       Checks.check(paramLong);
/*      */     }
/* 1917 */     return (nSetLayeredWindowAttributes(paramLong, paramInt1, paramByte, paramInt2, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nLoadIcon(long paramLong1, long paramLong2) {
/* 1927 */     long l = Functions.LoadIcon;
/* 1928 */     return nLoadIcon(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("HICON")
/*      */   public static long LoadIcon(@NativeType("HINSTANCE") long paramLong, @NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 1940 */     if (Checks.CHECKS) {
/* 1941 */       Checks.checkNT2(paramByteBuffer);
/*      */     }
/* 1943 */     return nLoadIcon(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("HICON")
/*      */   public static long LoadIcon(@NativeType("HINSTANCE") long paramLong, @NativeType("LPCTSTR") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1955 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1957 */       memoryStack.nUTF16(paramCharSequence, true);
/* 1958 */       long l = memoryStack.getPointerAddress();
/* 1959 */       return nLoadIcon(paramLong, l);
/*      */     } finally {
/* 1961 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nLoadCursor(long paramLong1, long paramLong2) {
/* 1972 */     long l = Functions.LoadCursor;
/* 1973 */     return nLoadCursor(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("HCURSOR")
/*      */   public static long LoadCursor(@NativeType("HINSTANCE") long paramLong, @NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 1984 */     if (Checks.CHECKS) {
/* 1985 */       Checks.checkNT2(paramByteBuffer);
/*      */     }
/* 1987 */     return nLoadCursor(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("HCURSOR")
/*      */   public static long LoadCursor(@NativeType("HINSTANCE") long paramLong, @NativeType("LPCTSTR") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/* 1998 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2000 */       memoryStack.nUTF16(paramCharSequence, true);
/* 2001 */       long l = memoryStack.getPointerAddress();
/* 2002 */       return nLoadCursor(paramLong, l);
/*      */     } finally {
/* 2004 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("HDC")
/*      */   public static long GetDC(@NativeType("HWND") long paramLong) {
/* 2018 */     long l = Functions.GetDC;
/* 2019 */     return JNI.callPP(paramLong, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean ReleaseDC(@NativeType("HWND") long paramLong1, @NativeType("HDC") long paramLong2) {
/* 2033 */     long l = Functions.ReleaseDC;
/* 2034 */     if (Checks.CHECKS) {
/* 2035 */       Checks.check(paramLong1);
/* 2036 */       Checks.check(paramLong2);
/*      */     } 
/* 2038 */     return (JNI.callPPI(paramLong1, paramLong2, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int GetSystemMetrics(int paramInt) {
/* 2049 */     long l = Functions.GetSystemMetrics;
/* 2050 */     return JNI.callI(paramInt, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean RegisterTouchWindow(@NativeType("HWND") long paramLong, @NativeType("ULONG") int paramInt) {
/* 2074 */     long l = Functions.RegisterTouchWindow;
/* 2075 */     if (Checks.CHECKS) {
/* 2076 */       Checks.check(l);
/* 2077 */       Checks.check(paramLong);
/*      */     } 
/* 2079 */     return (nRegisterTouchWindow(paramLong, paramInt, l) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean UnregisterTouchWindow(@NativeType("HWND") long paramLong) {
/* 2096 */     long l = Functions.UnregisterTouchWindow;
/* 2097 */     if (Checks.CHECKS) {
/* 2098 */       Checks.check(l);
/* 2099 */       Checks.check(paramLong);
/*      */     } 
/* 2101 */     return (nUnregisterTouchWindow(paramLong, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nIsTouchWindow(long paramLong1, long paramLong2) {
/* 2108 */     long l = Functions.IsTouchWindow;
/* 2109 */     if (Checks.CHECKS) {
/* 2110 */       Checks.check(l);
/* 2111 */       Checks.check(paramLong1);
/*      */     } 
/* 2113 */     return JNI.callPPI(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsTouchWindow(@NativeType("HWND") long paramLong, @NativeType("PULONG") IntBuffer paramIntBuffer) {
/* 2127 */     if (Checks.CHECKS) {
/* 2128 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 2130 */     return (nIsTouchWindow(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer)) != 0);
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
/*      */   public static int nGetTouchInputInfo(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 2152 */     long l = Functions.GetTouchInputInfo;
/* 2153 */     if (Checks.CHECKS) {
/* 2154 */       Checks.check(l);
/* 2155 */       Checks.check(paramLong1);
/*      */     } 
/* 2157 */     return nGetTouchInputInfo(paramLong1, paramInt1, paramLong2, paramInt2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetTouchInputInfo(@NativeType("HTOUCHINPUT") long paramLong, @NativeType("PTOUCHINPUT") TOUCHINPUT.Buffer paramBuffer, int paramInt) {
/* 2174 */     return (nGetTouchInputInfo(paramLong, paramBuffer.remaining(), paramBuffer.address(), paramInt) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean CloseTouchInputHandle(@NativeType("HTOUCHINPUT") long paramLong) {
/* 2193 */     long l = Functions.CloseTouchInputHandle;
/* 2194 */     if (Checks.CHECKS) {
/* 2195 */       Checks.check(l);
/* 2196 */       Checks.check(paramLong);
/*      */     } 
/* 2198 */     return (nCloseTouchInputHandle(paramLong, l) != 0);
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
/*      */   @NativeType("HMONITOR")
/*      */   public static long MonitorFromWindow(@NativeType("HWND") long paramLong, @NativeType("DWORD") int paramInt) {
/* 2211 */     long l = Functions.MonitorFromWindow;
/* 2212 */     if (Checks.CHECKS) {
/* 2213 */       Checks.check(paramLong);
/*      */     }
/* 2215 */     return JNI.callPP(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nGetMonitorInfo(long paramLong1, long paramLong2) {
/* 2222 */     long l = Functions.GetMonitorInfo;
/* 2223 */     if (Checks.CHECKS) {
/* 2224 */       Checks.check(paramLong1);
/*      */     }
/* 2226 */     return JNI.callPPI(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetMonitorInfo(@NativeType("HMONITOR") long paramLong, @NativeType("LPMONITORINFOEX") MONITORINFOEX paramMONITORINFOEX) {
/* 2240 */     return (nGetMonitorInfo(paramLong, paramMONITORINFOEX.address()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nEnumDisplayDevices(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 2247 */     long l = Functions.EnumDisplayDevices;
/* 2248 */     return JNI.callPPI(paramLong1, paramInt1, paramLong2, paramInt2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean EnumDisplayDevices(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer, @NativeType("DWORD") int paramInt1, @NativeType("PDISPLAY_DEVICE") DISPLAY_DEVICE paramDISPLAY_DEVICE, @NativeType("DWORD") int paramInt2) {
/* 2270 */     if (Checks.CHECKS) {
/* 2271 */       Checks.checkNT2Safe(paramByteBuffer);
/*      */     }
/* 2273 */     return (nEnumDisplayDevices(MemoryUtil.memAddressSafe(paramByteBuffer), paramInt1, paramDISPLAY_DEVICE.address(), paramInt2) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean EnumDisplayDevices(@NativeType("LPCTSTR") CharSequence paramCharSequence, @NativeType("DWORD") int paramInt1, @NativeType("PDISPLAY_DEVICE") DISPLAY_DEVICE paramDISPLAY_DEVICE, @NativeType("DWORD") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2295 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2297 */       memoryStack.nUTF16Safe(paramCharSequence, true); long l;
/* 2298 */       return 
/* 2299 */         (nEnumDisplayDevices(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), paramInt1, paramDISPLAY_DEVICE.address(), paramInt2) != 0);
/*      */     } finally {
/* 2301 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nEnumDisplaySettingsEx(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 2309 */     long l = Functions.EnumDisplaySettingsEx;
/* 2310 */     return JNI.callPPI(paramLong1, paramInt1, paramLong2, paramInt2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean EnumDisplaySettingsEx(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer, @NativeType("DWORD") int paramInt1, @NativeType("DEVMODE *") DEVMODE paramDEVMODE, @NativeType("DWORD") int paramInt2) {
/* 2342 */     if (Checks.CHECKS) {
/* 2343 */       Checks.checkNT2Safe(paramByteBuffer);
/*      */     }
/* 2345 */     return (nEnumDisplaySettingsEx(MemoryUtil.memAddressSafe(paramByteBuffer), paramInt1, paramDEVMODE.address(), paramInt2) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean EnumDisplaySettingsEx(@NativeType("LPCTSTR") CharSequence paramCharSequence, @NativeType("DWORD") int paramInt1, @NativeType("DEVMODE *") DEVMODE paramDEVMODE, @NativeType("DWORD") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2377 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2379 */       memoryStack.nUTF16Safe(paramCharSequence, true); long l;
/* 2380 */       return 
/* 2381 */         (nEnumDisplaySettingsEx(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), paramInt1, paramDEVMODE.address(), paramInt2) != 0);
/*      */     } finally {
/* 2383 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nChangeDisplaySettingsEx(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4) {
/* 2391 */     long l = Functions.ChangeDisplaySettingsEx;
/* 2392 */     return JNI.callPPPPI(paramLong1, paramLong2, paramLong3, paramInt, paramLong4, l);
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
/*      */   @NativeType("LONG")
/*      */   public static int ChangeDisplaySettingsEx(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer, @NativeType("DEVMODE *") DEVMODE paramDEVMODE, @NativeType("HWND") long paramLong1, @NativeType("DWORD") int paramInt, @NativeType("LPVOID") long paramLong2) {
/* 2417 */     if (Checks.CHECKS) {
/* 2418 */       Checks.checkNT2Safe(paramByteBuffer);
/*      */     }
/* 2420 */     return nChangeDisplaySettingsEx(MemoryUtil.memAddressSafe(paramByteBuffer), MemoryUtil.memAddressSafe((Pointer)paramDEVMODE), paramLong1, paramInt, paramLong2);
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
/*      */   @NativeType("LONG")
/*      */   public static int ChangeDisplaySettingsEx(@NativeType("LPCTSTR") CharSequence paramCharSequence, @NativeType("DEVMODE *") DEVMODE paramDEVMODE, @NativeType("HWND") long paramLong1, @NativeType("DWORD") int paramInt, @NativeType("LPVOID") long paramLong2) {
/*      */     MemoryStack memoryStack;
/* 2445 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2447 */       memoryStack.nUTF16Safe(paramCharSequence, true);
/*      */       long l;
/* 2449 */       return nChangeDisplaySettingsEx(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), MemoryUtil.memAddressSafe((Pointer)paramDEVMODE), paramLong1, paramInt, paramLong2);
/*      */     } finally {
/* 2451 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nGetCursorPos(long paramLong) {
/* 2459 */     long l = Functions.GetCursorPos;
/* 2460 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean GetCursorPos(@NativeType("LPPOINT") POINT paramPOINT) {
/* 2470 */     return (nGetCursorPos(paramPOINT.address()) != 0);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean SetCursorPos(int paramInt1, int paramInt2) {
/* 2484 */     long l = Functions.SetCursorPos;
/* 2485 */     return (JNI.callI(paramInt1, paramInt2, l) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nClipCursor(long paramLong) {
/* 2492 */     long l = Functions.ClipCursor;
/* 2493 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean ClipCursor(@NativeType("RECT const *") RECT paramRECT) {
/* 2505 */     return (nClipCursor(MemoryUtil.memAddressSafe((Pointer)paramRECT)) != 0);
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
/*      */   public static int ShowCursor(@NativeType("BOOL") boolean paramBoolean) {
/* 2521 */     long l = Functions.ShowCursor;
/* 2522 */     return JNI.callI(paramBoolean ? 1 : 0, l);
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
/*      */   @NativeType("HCURSOR")
/*      */   public static long SetCursor(@NativeType("HCURSOR") long paramLong) {
/* 2549 */     long l = Functions.SetCursor;
/* 2550 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nClientToScreen(long paramLong1, long paramLong2) {
/* 2557 */     long l = Functions.ClientToScreen;
/* 2558 */     if (Checks.CHECKS) {
/* 2559 */       Checks.check(paramLong1);
/*      */     }
/* 2561 */     return JNI.callPPI(paramLong1, paramLong2, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean ClientToScreen(@NativeType("HWND") long paramLong, @NativeType("LPPOINT") POINT paramPOINT) {
/* 2579 */     return (nClientToScreen(paramLong, paramPOINT.address()) != 0);
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
/*      */   @NativeType("SHORT")
/*      */   public static short GetAsyncKeyState(int paramInt) {
/* 2617 */     long l = Functions.GetAsyncKeyState;
/* 2618 */     return JNI.callS(paramInt, l);
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
/*      */   @NativeType("LPARAM")
/*      */   public static long GetMessageExtraInfo() {
/*      */     long l;
/* 2633 */     return JNI.callP(l = Functions.GetMessageExtraInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nSendInput(int paramInt1, long paramLong, int paramInt2) {
/* 2644 */     long l = Functions.SendInput;
/* 2645 */     return JNI.callPI(paramInt1, paramLong, paramInt2, l);
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
/*      */   @NativeType("UINT")
/*      */   public static int SendInput(@NativeType("PINPUT") INPUT.Buffer paramBuffer, int paramInt) {
/* 2677 */     return nSendInput(paramBuffer.remaining(), paramBuffer.address(), paramInt);
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
/*      */   @NativeType("UINT")
/*      */   public static int GetDpiForSystem() {
/* 2697 */     long l = Functions.GetDpiForSystem;
/* 2698 */     if (Checks.CHECKS) {
/* 2699 */       Checks.check(l);
/*      */     }
/* 2701 */     return JNI.callI(l);
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
/*      */   @NativeType("UINT")
/*      */   public static int GetDpiForWindow(@NativeType("HWND") long paramLong) {
/* 2717 */     long l = Functions.GetDpiForWindow;
/* 2718 */     if (Checks.CHECKS) {
/* 2719 */       Checks.check(l);
/* 2720 */       Checks.check(paramLong);
/*      */     } 
/* 2722 */     return JNI.callPI(paramLong, l);
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
/*      */   @NativeType("DPI_AWARENESS")
/*      */   public static int GetAwarenessFromDpiAwarenessContext(@NativeType("DPI_AWARENESS_CONTEXT") long paramLong) {
/* 2738 */     long l = Functions.GetAwarenessFromDpiAwarenessContext;
/* 2739 */     if (Checks.CHECKS) {
/* 2740 */       Checks.check(l);
/* 2741 */       Checks.check(paramLong);
/*      */     } 
/* 2743 */     return JNI.callPI(paramLong, l);
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
/*      */   @NativeType("DPI_AWARENESS_CONTEXT")
/*      */   public static long GetThreadDpiAwarenessContext() {
/* 2760 */     long l = Functions.GetThreadDpiAwarenessContext;
/* 2761 */     if (Checks.CHECKS) {
/* 2762 */       Checks.check(l);
/*      */     }
/* 2764 */     return JNI.callP(l);
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
/*      */   @NativeType("DPI_AWARENESS_CONTEXT")
/*      */   public static long GetWindowDpiAwarenessContext(@NativeType("HWND") long paramLong) {
/* 2780 */     long l = Functions.GetWindowDpiAwarenessContext;
/* 2781 */     if (Checks.CHECKS) {
/* 2782 */       Checks.check(l);
/* 2783 */       Checks.check(paramLong);
/*      */     } 
/* 2785 */     return JNI.callPP(paramLong, l);
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
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsValidDpiAwarenessContext(@NativeType("DPI_AWARENESS_CONTEXT") long paramLong) {
/* 2801 */     long l = Functions.IsValidDpiAwarenessContext;
/* 2802 */     if (Checks.CHECKS) {
/* 2803 */       Checks.check(l);
/*      */     }
/* 2805 */     return (JNI.callPI(paramLong, l) != 0);
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
/*      */   @NativeType("DPI_AWARENESS_CONTEXT")
/*      */   public static long SetThreadDpiAwarenessContext(@NativeType("DPI_AWARENESS_CONTEXT") long paramLong) {
/* 2822 */     long l = Functions.SetThreadDpiAwarenessContext;
/* 2823 */     if (Checks.CHECKS) {
/* 2824 */       Checks.check(l);
/* 2825 */       Checks.check(paramLong);
/*      */     } 
/* 2827 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean IsTouchWindow(@NativeType("HWND") long paramLong, @NativeType("PULONG") int[] paramArrayOfint) {
/* 2833 */     long l = Functions.IsTouchWindow;
/* 2834 */     if (Checks.CHECKS) {
/* 2835 */       Checks.check(l);
/* 2836 */       Checks.check(paramLong);
/* 2837 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2839 */     return (JNI.callPPI(paramLong, paramArrayOfint, l) != 0);
/*      */   }
/*      */   
/*      */   public static native short nRegisterClassEx(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nUnregisterClass(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nCreateWindowEx(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int nDestroyWindow(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nSetWindowPos(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3);
/*      */   
/*      */   public static native int nSetWindowText(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nGetMessage(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native int nWaitMessage(long paramLong);
/*      */   
/*      */   public static native int nPostMessage(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nSendMessage(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nAdjustWindowRectEx(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native int nGetWindowRect(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nMoveWindow(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
/*      */   
/*      */   public static native int nGetWindowPlacement(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nSetWindowPlacement(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nSetWindowLongPtr(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nGetWindowLongPtr(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native long nSetClassLongPtr(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nGetClassLongPtr(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nSetLayeredWindowAttributes(long paramLong1, int paramInt1, byte paramByte, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native long nLoadIcon(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nLoadCursor(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nRegisterTouchWindow(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nUnregisterTouchWindow(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nGetTouchInputInfo(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native int nCloseTouchInputHandle(long paramLong1, long paramLong2); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\User32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */