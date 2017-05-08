package com.natalia.servlet;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String method;
    private String URI;
    private final Map<String,String> parameters = new HashMap<String, String>();

    public Request(String method, String URI, Map<String, String[]> parameters) {
        this.method = method;
        this.URI = URI;
        if (parameters != null) {
            for (String param: parameters.keySet()) {
                Object value = parameters.get(param);
                if (value != null) {
                    if (value.getClass() == String.class) {
                        this.parameters.put(param, (String)value);
                    } else if(value.getClass() == String[].class) {
                        String[] valueArray = (String[]) value;
                        this.parameters.put(param, valueArray[0]);
                    }
                }
            }
        }
    }

    public static Request create(String method, String URI) {
        return new Request(method, URI, null);
    }

    public String getParameter(String param) {
        return parameters.get(param);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (method != null ? !method.equals(request.method) : request.method != null) return false;
        return URI != null ? URI.equals(request.URI) : request.URI == null;
    }

    @Override
    public int hashCode() {
        int result = method != null ? method.hashCode() : 0;
        result = 31 * result + (URI != null ? URI.hashCode() : 0);
        return result;
    }
}
