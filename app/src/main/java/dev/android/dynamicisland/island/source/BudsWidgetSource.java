package dev.android.dynamicisland.island.source;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.RemoteViews;
import dev.android.dynamicisland.island.graphics.GlyphIcon;
import dev.android.dynamicisland.island.model.IslandItem;
import dev.android.dynamicisland.settings.ModuleSettings;
import dev.android.dynamicisland.xposed.Diagnostics;
import dev.android.dynamicisland.xposed.Refl;
import dev.android.dynamicisland.xposed.XLog;
import java.util.List;

/**
 * Keeps a pill in the island while Samsung Galaxy Buds are connected, and opens into the Buds' own home-screen
 * widget (battery + noise control modes). The widget is hosted here through an AppWidgetHost; its RemoteViews are
 * shown by the existing RemoteViews card, so a tap on a mode button is handled by the widget itself.
 */
public final class BudsWidgetSource {
    /** The Galaxy Buds Manager widget (found with: dumpsys appwidget | grep -i buds). */
    private static final ComponentName PROVIDER = new ComponentName(
            "com.samsung.accessory.paranmgr",
            "com.samsung.accessory.hearablemgr.core.appwidget.WidgetBudsControllerProvider");
    /** A name part that tells the earbuds apart from other Bluetooth audio (a car, a speaker). */
    private static final String NAME_HINT = "buds";
    private static final int HOST_ID = 0x44494231;
    private static final String KEY = "event:buds";
    /** The widget size asked for, in dp: a 4x1 strip. */
    private static final int WIDGET_WIDTH_DP = 360;
    private static final int WIDGET_HEIGHT_DP = 105;

    private final Context ctx;
    private final Handler main;
    private final Runnable onChange;
    private AudioManager audio;
    private boolean registered;
    private String budsName;
