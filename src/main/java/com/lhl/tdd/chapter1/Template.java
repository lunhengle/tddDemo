package com.lhl.tdd.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lunhengle on 16-5-9.
 */
public class Template {
    private String variableValue;
    private String templateText;
    private Map<String, String> variables;

    public Template(String templateText) {
        variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String name, String value) {
        this.variables.put(name, value);
    }

    public String evaluate() {
        String result = templateText;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }
}
