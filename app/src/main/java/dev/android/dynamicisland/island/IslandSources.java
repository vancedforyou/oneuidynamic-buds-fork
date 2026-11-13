package dev.android.dynamicisland.island;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import dev.android.dynamicisland.island.graphics.GlyphIcon;
import dev.android.dynamicisland.island.model.IslandItem;
import dev.android.dynamicisland.island.source.CallSource;
import dev.android.dynamicisland.island.source.IncomingCallSource;
import dev.android.dynamicisland.island.source.WhatsAppCallClock;
import dev.android.dynamicisland.island.source.BudsWidgetSource;
import dev.android.dynamicisland.island.source.CastSource;
import dev.android.dynamicisland.island.source.EventSource;
import dev.android.dynamicisland.island.source.ChargingSource;
import dev.android.dynamicisland.island.source.HeadsetSource;
import dev.android.dynamicisland.island.source.HotspotSource;
import dev.android.dynamicisland.island.source.UnlockSource;
import dev.android.dynamicisland.island.source.MediaSource;
import dev.android.dynamicisland.island.source.OaSource;
import dev.android.dynamicisland.island.source.PeekSource;
import dev.android.dynamicisland.island.source.PrivacySource;
import dev.android.dynamicisland.island.source.PromotedSource;
import dev.android.dynamicisland.island.source.ProgressSource;
import dev.android.dynamicisland.island.source.RecorderNotificationSource;
import dev.android.dynamicisland.island.source.RuleSource;
import dev.android.dynamicisland.island.source.TorchSource;
import dev.android.dynamicisland.settings.ModuleSettings;
import dev.android.dynamicisland.xposed.XLog;
import dev.android.dynamicisland.xposed.hooks.HideDuplicated;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The set of data sources behind the island and the step that gathers their items into one list.
 * Sources are isolated from each other: one that throws only loses its own islands.
 */
final class IslandSources {
    /** What one gathering pass produced. */
    static final class Gathered {
        final List<IslandItem> items = new ArrayList<>();
        IslandItem glowSession;
        /** Keys of items a source left out because their app is in the foreground. */
        final Set<String> hiddenByForeground = new HashSet<>();
        /** Packages whose chips the launcher should animate into the island. */
