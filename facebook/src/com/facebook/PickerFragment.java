/**
 * Copyright 2012 Facebook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook;

import android.os.Bundle;

public interface PickerFragment<T extends GraphObject> {
    String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.GraphObjectListFragment.ShowPictures";

    OnDataChangedListener getOnDataChangedListener();

    void setOnDataChangedListener(OnDataChangedListener onDataChangedListener);

    OnSelectionChangedListener getOnSelectionChangedListener();

    void setOnSelectionChangedListener(
            OnSelectionChangedListener onSelectionChangedListener);

    OnErrorListener getOnErrorListener();

    void setOnErrorListener(OnErrorListener onErrorListener);

    public GraphObjectFilter<T> getFilter();

    public void setFilter(GraphObjectFilter<T> filter);

    Session getSession();

    void setSession(Session session);

    boolean getShowPictures();

    void setShowPictures(boolean showPictures);

    void loadData(boolean forceReload);

    void setSettingsFromBundle(Bundle inState);

    public interface OnErrorListener {
        void onError(FacebookException error);
    }

    public interface OnDataChangedListener {
        void onDataChanged();
    }

    public interface OnSelectionChangedListener {
        void onSelectionChanged();
    }

    public interface GraphObjectFilter<T> {
        boolean includeItem(T graphObject);
    }
}
