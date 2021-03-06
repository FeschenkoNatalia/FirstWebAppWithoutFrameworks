package com.natalia.view;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {
    private String view;
    private final Map<String, Object> attributes = new HashMap<>();
    private final Map<String, String> newCookie = new HashMap<>();
    private boolean hasCookies = false;

    public ViewModel() {}

    public ViewModel(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ViewModel withAttribute(String attr, Object value) {
        attributes.put(attr, value);
        return this;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Object getAttribute(String attr) {
        return attributes.get(attr);
    }

    public ViewModel addCookie(String name, String value) {
        hasCookies = true;
        newCookie.put(name, value);
        return this;
    }

    public boolean hasCookies() {
        return hasCookies;
    }

    public Map<String, String> getNewCookies() {
        return newCookie;
    }
}
