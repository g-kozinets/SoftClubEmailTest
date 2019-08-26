package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Letter {
    private String sender;
    private String subject;
    private String text;

    public Letter(WebElement element) {
        sender = element.findElement(By.cssSelector(".zA.zE .afn .bA4 .zF")).getAttribute("email");
        subject = element.findElement(By.cssSelector(".F.cf.zt .zA.zE .y6 .bqe")).getText();
        text = element.findElement(By.cssSelector(".F.cf.zt .zA.zE .y2")).getText();
    }

    @Override
    public String toString() {
        return sender + " " + subject + text;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
