package com.gitee.freakchicken.dbapi.basic.util;

import java.util.HashSet;
import java.util.Set;

public class IPRuleCache {
    public static String status = "off";

    public static String mode = "black";

    public static Set<String> blackIPSet = new HashSet<>();

    public static Set<String> whiteIPSet = new HashSet<>();
}
