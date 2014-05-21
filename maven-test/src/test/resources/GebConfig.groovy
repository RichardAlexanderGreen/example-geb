/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.Dimension

def instantiateDriver(String className) {
    def driverInstance = Class.forName(className).newInstance()
    driverInstance.manage().window().size = new Dimension(1280, 1024)
    driverInstance
}

environments {
    chrome {
        driver = { instantiateDriver 'org.openqa.selenium.chrome.ChromeDriver' }
    }

    firefox {
        driver = { instantiateDriver 'org.openqa.selenium.firefox.FirefoxDriver' }
    }

    htmlunit {
        // See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
        driver = { Class.forName('org.openqa.selenium.htmlunit.HtmlUnitDriver').newInstance() }
    }
}