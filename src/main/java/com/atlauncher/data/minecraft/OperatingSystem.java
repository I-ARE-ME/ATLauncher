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

import com.atlauncher.utils.OS;

public enum OperatingSystem {
    LINUX("linux"), WINDOWS("windows"), OSX("osx");

    public final String name;

    private OperatingSystem(String name) {
        this.name = name;
    }

    public static OperatingSystem getOS() {
        if (OS.isWindows()) {
            return OperatingSystem.WINDOWS;
        } else if (OS.isMac()) {
            return OperatingSystem.OSX;
        } else {
            return OperatingSystem.LINUX;
        }
    }

}
