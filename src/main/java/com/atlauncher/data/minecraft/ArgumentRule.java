/*
 * ATLauncher - https://github.com/ATLauncher/ATLauncher
 * Copyright (C) 2013-2019 ATLauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.atlauncher.data.minecraft;

import java.util.List;

import com.atlauncher.annot.Json;

@Json
public class ArgumentRule {
    public List<Rule> rules;
    public Object value;

    public ArgumentRule(List<Rule> rules, Object value) {
        this.rules = rules;
        this.value = value;
    }

    public String getValue() {
        if (this.value instanceof String) {
            return (String) this.value;
        }

        StringBuilder argBuilder = new StringBuilder();

        for (String arg : (List<String>) this.value) {
            argBuilder.append(arg + ' ');
        }

        String arguments = argBuilder.toString();

        // remove last extra space
        arguments = arguments.substring(0, arguments.length() - 1);

        return arguments;
    }

    public Boolean applies() {
        if (this.rules == null) {
            return true; // No rules setup so we need it
        }

        return this.rules.stream().filter(rule -> rule.applies()).allMatch(rule -> rule.action == Action.ALLOW);
    }
}
