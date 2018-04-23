package com.ciclum.steps;

import com.ciclum.pages.AbstractPage;
import org.jbehave.core.annotations.AfterStories;

public class LifeCycleSteps {
    @AfterStories
    public void closeBrowser() {
        AbstractPage.closePage();
    }
}
