/*
 * Copyright (C) 2021 CarbonROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.carbonrom.carbonfibers.fragments.gestures;

import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.provider.SearchIndexableResource;

import androidx.preference.*;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.gestures.GestureSettings;
import com.android.settings.R;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.Indexable;
import com.android.settingslib.search.SearchIndexable;

import java.util.ArrayList;
import java.util.List;

@SearchIndexable
public class Gestures extends GestureSettings implements Indexable {
    private static final String TAG = "Gestures";

    private static final String KEY_ASSIST = "gesture_assist_input_summary";
    private static final String KEY_SWIPE_DOWN = "gesture_swipe_down_fingerprint_input_summary";
    private static final String KEY_DOUBLE_TAP_POWER = "gesture_double_tap_power_input_summary";
    private static final String KEY_DOUBLE_TWIST = "gesture_double_twist_input_summary";
    private static final String KEY_NAVIGATION_INPUT = "gesture_system_navigation_input_summary";
    private static final String KEY_TAP_SCREEN = "gesture_tap_screen_input_summary";
    private static final String KEY_DOUBLE_TAP_SCREEN = "gesture_double_tap_screen_input_summary";
    private static final String KEY_PICK_UP = "gesture_pick_up_input_summary";
    private static final String KEY_PREVENT_RINGING = "gesture_prevent_ringing_summary";
    private static final String KEY_GESTURE_GLOBAL_ACTIONS_PANEL = "gesture_global_actions_panel_summary";

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.CARBONFIBERS;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        super.onCreatePreferences(savedInstanceState, rootKey);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {
                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                                                                            boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();

                    SearchIndexableResource sir = new SearchIndexableResource(context);
                    sir.xmlResId = R.xml.gestures;
                    result.add(sir);
                    return result;
                }

                @Override
                public List<String> getNonIndexableKeys(Context context) {
                    List<String> keys = super.getNonIndexableKeys(context);
                    // Duplicates in summary and details pages.
                    keys.add(KEY_ASSIST);
                    keys.add(KEY_SWIPE_DOWN);
                    keys.add(KEY_DOUBLE_TAP_POWER);
                    keys.add(KEY_DOUBLE_TWIST);
                    keys.add(KEY_NAVIGATION_INPUT);
                    keys.add(KEY_TAP_SCREEN);
                    keys.add(KEY_DOUBLE_TAP_SCREEN);
                    keys.add(KEY_PICK_UP);
                    keys.add(KEY_PREVENT_RINGING);
                    keys.add(KEY_GESTURE_GLOBAL_ACTIONS_PANEL);
                    return keys;
                }
            };
}
