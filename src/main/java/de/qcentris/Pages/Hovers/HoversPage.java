package de.qcentris.Pages.Hovers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {

    private final WebDriver webDriver;
    private final List<WebElement> figuresElements;
    private final Actions actions;

    public HoversPage (WebDriver driver) {
        this.webDriver = driver;
        this.actions = new Actions(this.webDriver);
        this.figuresElements = driver.findElements(By.className("figure"));
    }

    /**
     * @param index start by 1
     * @return
     */
    public FigureCaption hoverOverFigure (int index) {
        WebElement actualElement = this.figuresElements.get(index - 1);
        this.actions.moveToElement(actualElement).perform();
        return new FigureCaption(actualElement);
    }

    public class FigureCaption {
        private WebElement actualHoveredFigure;
        private By actualTitle = By.tagName("h5");
        private By actuaLink = By.tagName("a");

        FigureCaption (WebElement tmpWebElem) {
            this.actualHoveredFigure = tmpWebElem;
        }

        public boolean isFigureCaptionDisplayed () {
            return this.actualHoveredFigure.isDisplayed();
        }

        public String getTitleText () {
            return this.actualHoveredFigure.findElement(this.actualTitle).getText();
        }

        public String getLinkValue () {
            return this.actualHoveredFigure.findElement(this.actuaLink).getAttribute("href");
        }

        public String getLinkText () {
            return this.actualHoveredFigure.findElement(this.actuaLink).getText();
        }
    }

}
