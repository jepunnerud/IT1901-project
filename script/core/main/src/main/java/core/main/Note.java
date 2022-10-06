package core.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.AbstractMap;

public class Note {

    private String title, text;
    private boolean isPinned = false;
    private String color = "white";

    // Maybe implement checkboxes

    /// Create note with already existing title and text (When loading in already
    /// existing notes maybe?)
    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void pin() {
        isPinned = true;
    }

    public void unPin() {
        isPinned = false;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setColor(String color) {
        if (isValidColor(color)) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("This is not a valid color");
        }
    }

    public Map<String, List<Integer>> getSelectableColors() {
        return Stream.of(
                new AbstractMap.SimpleImmutableEntry<>("red", Arrays.asList(255, 0, 0)),
                new AbstractMap.SimpleImmutableEntry<>("blue", Arrays.asList(0, 0, 255)),
                new AbstractMap.SimpleImmutableEntry<>("coral", Arrays.asList(255, 99, 80)),
                new AbstractMap.SimpleImmutableEntry<>("khaki", Arrays.asList(240, 230, 140)),
                new AbstractMap.SimpleImmutableEntry<>("aquamarine", Arrays.asList(102, 205, 170)),
                new AbstractMap.SimpleImmutableEntry<>("sea green", Arrays.asList(32, 178, 170)),
                new AbstractMap.SimpleImmutableEntry<>("powder blue", Arrays.asList(176, 224, 230)),
                new AbstractMap.SimpleImmutableEntry<>("yellow", Arrays.asList(255, 255, 0)),
                new AbstractMap.SimpleImmutableEntry<>("green", Arrays.asList(0, 128, 0)),
                new AbstractMap.SimpleImmutableEntry<>("orchid", Arrays.asList(218, 112, 214)),
                new AbstractMap.SimpleImmutableEntry<>("violet red", Arrays.asList(199, 21, 133)),
                new AbstractMap.SimpleImmutableEntry<>("lemon chiffon", Arrays.asList(255, 250, 205)),
                new AbstractMap.SimpleImmutableEntry<>("misty rose", Arrays.asList(255, 228, 225)),
                new AbstractMap.SimpleImmutableEntry<>("alice blue", Arrays.asList(240, 248, 255)),
                new AbstractMap.SimpleImmutableEntry<>("white", Arrays.asList(255, 255, 255)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<Integer> getColorValues() {
        return getSelectableColors().get(getColor());
    }

    public String getColor() {
        return color;
    }

    private boolean isValidColor(String color) {
        return getSelectableColors().containsKey(color);
    }

    @Override
    public String toString() {
        return "title:" + title + ", text: " + text;
    }
}