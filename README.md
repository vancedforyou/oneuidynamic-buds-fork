<p align="center">
  <img src="docs/hero.png" alt="Dynamic Island: live cards for Samsung One UI">
</p>

<h3 align="center">make the status bar alive!</h3>

<p align="center">
  <b>A Dynamic Island for Samsung One UI.</b><br>
  A pill around the camera hole that opens into live cards for calls, music, navigation, timers and notifications.
</p>

make a card.
- The **English rules** are written for this project from how English-language apps word their notifications; no LiveBridge file is copied. They cover:
  - **Food delivery:** DoorDash, Uber Eats, Grubhub, Postmates, Instacart, Domino's, Pizza Hut, Starbucks, Chipotle, Deliveroo, Just Eat, Wolt, Glovo and others (order placed, preparing, on the way, arriving, delivered).
  - **Parcels:** Amazon, UPS, FedEx, USPS, DHL, Royal Mail, Shop, Evri, Canada Post, Australia Post and others (label created, in transit, at the local facility, out for delivery, delivered).
  - **Ride hailing:** Uber, Lyft, Bolt, Grab, Ola, DiDi, FREE NOW, Cabify, inDrive (finding a driver, driver assigned, on the way, arrived, trip complete).
  - **Navigation:** Google Maps, Waze, Citymapper, HERE, TomTom, MapQuest and others (turns with the distance in miles, feet or kilometres, getting off, arrival).
  - **Accessories:** connection, disconnection, fully charged and low-battery percentages for Pixel Buds, Fitbit, Garmin, Galaxy Wearable and other accessory apps.
  - Chat, mail, social, video and news apps are left out. Stage names follow the phone's language: English on English phones, Korean on Korean ones.
- The **English rules** are written for this project from how English-language apps word their notifications; no LiveBridge file is copied. They cover:
  - **Food delivery:** DoorDash, Uber Eats, Grubhub, Postmates, Instacart, Domino's, Pizza Hut, Starbucks, Chipotle, Deliveroo, Just Eat, Wolt, Glovo and others (order placed, preparing, on the way, arriving, delivered).
  - **Parcels:** Amazon, UPS, FedEx, USPS, DHL, Royal Mail, Shop, Evri, Canada Post, Australia Post and others (label created, in transit, at the local facility, out for delivery, delivered).
  - **Ride hailing:** Uber, Lyft, Bolt, Grab, Ola, DiDi, FREE NOW, Cabify, inDrive (finding a driver, driver assigned, on the way, arrived, trip complete).
  - **Navigation:** Google Maps, Waze, Citymapper, HERE, TomTom, MapQuest and others (turns with the distance in miles, feet or kilometres, getting off, arrival).
  - **Accessories:** connection, disconnection, fully charged and low-battery percentages for Pixel Buds, Fitbit, Garmin, Galaxy Wearable and other accessory apps.
  - Chat, mail, social, video and news apps are left out. Stage names follow the phone's language: English on English phones, Korean on Korean ones.
- Cards of finished processes leave after a few minutes, the others after hours; events that repeat all day are shown once per cooldown; a signal can carry a percentage that becomes the card's progress.
- Rule files use the format of LiveBridge's dictionary. Patterns that could hang the phone (runaway regular expressions) are refused when a file is read, and very long texts are cut before matching.

### Rule manager

- A **switch for every rule**, a list showing its stages, apps and patterns, and a detail page for each rule.
- **Add to the module's rules without touching them:** name a stage, add a pattern to it, add more stages (up to nine), add an app (from your installed apps) or an excluded wording; undo all your changes of a rule in one tap.
- **Make a new rule** for an app or a wording of your own.
- **Try a notification:** type an app and a text and see at once which rule fires and at which stage, whether it would be read as a verification code, and what progress it holds.
- **Import / export** your rules as JSON through the clipboard; reset everything.

### System events

- **Charging** (fast or wireless, with the live percentage), **low battery**, **sound mode** (silent, vibrate, ring), **Bluetooth audio** connecting (with its battery level).
- **Optional device cards:** Live charging details, charging statistics and wired/USB headset alerts are off by default under **Notifications & activities → System events**. The charging card retains event priority and replaces the brief charging popup while active. Statistics require the charging card; disabling either stops the corresponding collection. Power is estimated at the battery, and screen-state charge changes are estimates based on observed fuel-gauge reporting windows. **Advanced → Camera calibration** offers 0–16dp extra text clearance beside the cutout; 0 preserves the original spacing. More optional cards, all off by default: **Keep the headset card while connected**, a **Hotspot card** (devices, data used, time), an **Unlock notice** (fingerprint, face, trusted device or PIN, for phones with a lock) under **Notifications & activities → System events**, and under **Notification cards** the progress bar on notification cards plus **Progress of the app you are using** and **Progress of ordinary notifications** (cards for notifications that carry a real progress bar).
- **Samsung battery charging effect:** **Notifications & activities → System events → Show Samsung battery charging effect** is off by default. It suppresses the expanding, coloured charging animation in the status bar while retaining the regular battery icon, percentage, charging indicator, sounds and island alerts. Both the checked One UI 9 Compose path and the BatteryEvent scheduler path are handled when present; unsupported builds retain their stock behaviour.
- **Camera, microphone and location in use:** which app uses which sensor; a tap opens that app's permission page. (Location is off by default because navigation and weather apps use it all day.)
- **Quick-setting feedback:** Do Not Disturb, airplane mode, power saving, hotspot and auto-rotate being switched on or off.
- **Flashlight brightness:** While the torch is on, tapping the island opens a card with a big iOS style slider for its brightness levels (5 on Galaxy phones, read from the camera) and a turn-off button. On a phone whose torch has a single level the card has no slider, only the state and the turn-off button (the *Flashlight card* switch can be turned off to get the plain "flashlight on" popup instead).
- Every group can be switched off separately.

### Settings app

- **Ambient glow (on by default, music sessions only):** all compact pills share the active music session colours and sound response, even when the music pill itself is hidden. Album matching uses the waveform palette. Pausing makes the halo faint; ending the session smoothly fades its last colours out over 1.2 seconds. Choose music-only or all-activity visibility, brightness (default 45%) and dynamic strength (0–100%, default 50%) with a live preview. Theme and separate preset/HSV/HEX colours remain available. Low-performance mode disables the halo.
- **Low-performance mode (off by default):** replaces content blur with a crossfade and background blur with an opaque black card; keeps static album colours and artwork, static waveforms without audio analysis, and settled icon frames with current battery state. Continuous motion is capped at 30 fps, touch feedback and expansion/collapse at 60 fps. Individual settings are preserved and restored when the mode is turned off; notifications, calls, timers and music controls keep working.
- Five groups: **Notifications & activities**, **Appearance**, **Behavior**, **Advanced & troubleshooting** and **App info**, with **Restart System UI** and the settings language at the bottom of the home page. English, Korean, Japanese, Simplified Chinese and Russian; light and dark themes. Most changes apply within a few seconds without restarting System UI.
- **Position and size:** live status-bar preview, automatic or custom widths, sliders, numeric input and one-step adjustment. Position, size and camera calibration reset separately. Camera cutout calibration is at the bottom of the position and size page.
- **Clear choices:** **Notification cards** can be off (stock banners), only for notifications that pop up as a banner, or also for silent ones. Notifications of the app you are using keep the stock banner by default; switch **Notifications from the app you are using** on to get cards for them too. App filters affect ordinary notification cards only; search by name or package, view selected apps and save or cancel changes.
- **Appearance and behavior:** default/custom accent colour with a cancellable HSV/HEX editor; large event icons by default, optional small icons; charging battery icon hidden by default. Animation uses an actual island-renderer preview and saves immediately. Waveform motion can react to audio or use a demo animation.
- **Timing and recovery:** automatic activity opening is off by default. When enabled, its display time (default 4 seconds) is separate from manual-card auto-collapse (6 seconds) and paused-music retention (60 seconds). Experimental notification recovery is off by default and intended only for compatibility problems.
- **Language and status:** settings language is selectable in App info; island cards follow the device language. The home connection check requires a new System UI response, not an old saved report. Back navigation restores scroll position.

### Reliability

- Hooks are installed in **isolated groups**: one that cannot attach to your System UI build does not take the others down. Every hook body and every data source is contained, so a failure becomes a log line instead of a System UI crash.
- A **crash guard** switches the module off after repeated System UI crashes or unstable starts, forgets that verdict after a system update or twelve hours, and keeps the cause of the last crash.
- A **diagnostics page** shows the System UI version, the start-up stages, hooks that did not attach, recent errors and the previous crash, ready to copy into an issue.
- If System UI never reports its status bar, the island creates its window by itself after fifteen seconds.
- The app has **no network permission** and no data leaves the phone.

## Requirements

- A Samsung device on One UI 7 / 8 / 9 (Android 15 / 16 / 17) with the stock System UI. One UI 8 and 9 are used on real phones; One UI 7 support is new and checked against one System UI build only, not on a device (see [docs/COMPATIBILITY.md](docs/COMPATIBILITY.md)).
- LSPosed (module minimum SDK 35).
- Root is only needed for the optional **Restart System UI** button.

## Install

1. Install a signed Dynamic Island APK from the project's **Releases**, if available. Otherwise, build it from source (below).
2. In LSPosed, enable **Dynamic Island** and set its scope to **System UI** (`com.android.systemui`).
3. Restart System UI (the app's **Restart System UI** button, or reboot).
4. Open Dynamic Island from the launcher. Changes apply within a few seconds, no restart needed.

## Settings

| Page | What it holds |
|---|---|
| Notifications & activities | Notification cards (off, banners only, or banners and silent notifications), app filter (all apps except selected / selected apps only), system events grouped as charging, sound and headphones, and quick settings and flashlight; automatic card rules with their editor, downloads, calls and verification codes |
| Appearance | A live island preview above the settings: animation, material, outline, card corners, event icon size, flashlight controls, card header, colour icons and battery icon are chips or switches that play on the preview as soon as they are chosen; accent colour, ambient glow, and position, size and camera calibration |
| Behavior | Full-screen visibility, low-performance mode, haptics, music player in the shade, audio / demo waveform and microphone input, and separate card timers |
| Advanced & troubleshooting | Experimental recovery, diagnostics |
| App info | Version, What's new, author and credits |

## If it does not work

Open **Advanced & troubleshooting → Diagnostics** in the app after restarting System UI. It lists the System UI version, the start-up stages, hooks that could not attach, errors and the previous crash. Use **Copy report** and send it with the issue.

## Build from source

Requires JDK 17+ and the Android SDK (compile SDK 36).

```bash
./gradlew assembleRelease     # unsigned APK in app/build/outputs/apk/release
KEYSTORE_PASSWORD=... scripts/sign.sh   # builds, aligns and signs -> release/DynamicIsland-<version>.apk
./gradlew testReleaseUnitTest # unit tests and headless render tests
./gradlew testReleaseUnitTest -Prender # optional PNG captures for visual review
```

`scripts/sign.sh` takes the keystore password from `KEYSTORE_PASSWORD` and creates a self-signed key in `release-keys/` on first run (git-ignored). Keep it: updates must be signed with the same key. See [`docs/DEVELOPMENT.md`](docs/DEVELOPMENT.md) for the source layout, hook notes, rules format and test setup.

## Releases

This README describes the current source tree; changes awaiting release may not be in the latest stable APK.

Signed APKs are published on the [Releases](../../releases) page; the build is automated (see [`docs/DEVELOPMENT.md`](docs/DEVELOPMENT.md)). Every release is signed with the same key, so a new version installs as an update over the old one.

## Privacy

The module runs inside System UI and reads the notifications System UI already holds. It has no network permission and sends nothing anywhere. Settings and the diagnostics report stay on the device; the report holds no notification text.

The optional concurrent microphone waveform uses short in-memory microphone buffers to compute levels. It is off by default; audio is neither stored nor transmitted.

## Disclaimer

Dynamic Island is an independent, unofficial project and is not affiliated with or endorsed by Samsung. It hooks private System UI classes that may change with any update, and it has been used on real phones running One UI 8 and 9, while One UI 7 and Nothing OS are not confirmed on a device (see [docs/COMPATIBILITY.md](docs/COMPATIBILITY.md)). Use it at your own risk.

## License

[MIT](LICENSE) © 2026 sampple-korea.

## Made by [sampple-korea](https://github.com/sampple-korea)

## Credits

- [LiveBridge](https://github.com/appsfolder/livebridge) — the rule file format this project reads (no LiveBridge files are bundled)
- [Xposed API](https://api.xposed.info/) (Apache-2.0, `app/libs/xposed-api-82.jar`) and [LSPosed](https://github.com/LSPosed/LSPosed)
* DynamicIsland by @cryyear — This project began as a modification of that module’s APK, but was later reimplemented with its own codebase and architecture. It is now developed and maintained independently.
- [@UnkilBonki](https://t.me/UnkilBonki) on Telegram — bug fixes, testing and help.
