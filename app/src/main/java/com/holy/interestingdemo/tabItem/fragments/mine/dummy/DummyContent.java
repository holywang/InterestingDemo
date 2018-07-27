package com.holy.interestingdemo.tabItem.fragments.mine.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    private DummyContent() {

    }

    private static class LazyHolder {
        private static final DummyContent INSTANCE = new DummyContent();
    }

    public static final DummyContent getInstance() {
        return LazyHolder.INSTANCE;
    }

    public DummyContent setArray(String[] array) {
        ITEMS = new ArrayList<>();
        ITEM_MAP = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            addItem(createDummyItem(i, array[i]));
        }
        return this;
    }

    /**
     * An array of sample (dummy) items.
     */
    public List<DummyItem> ITEMS ;

    /**
     * A map of sample (dummy) items, by ID.
     */
    public Map<String, DummyItem> ITEM_MAP;


    private void addItem(DummyItem item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.title, item);
    }

    private DummyItem createDummyItem(int position, String title) {
        return new DummyItem(title, position);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

        public final String title;
        public final int position;

        public DummyItem(String title, int position) {
            this.title = title;
            this.position = position;
        }

    }
}
