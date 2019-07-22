package com.tws.refactoring.extract_variable;

public class BannerRender {
    String renderBanner(String platform, String browser) {
        boolean isMAC = platform.toUpperCase().indexOf("MAC") > -1;
        boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
        if (isMAC && isIE) {
            return "IE on Mac?";
        }
        return "banner";
    }
}
