import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        int retries = 3; // thử click tối đa 3 lần

        for (int attempt = 1; attempt <= retries; attempt++) {
            try {
                // 1. Chờ element clickable
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

                // 2. Scroll element vào giữa màn hình (fix lỗi React/Angular bị che)
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

                // 3. Chờ overlay loader biến mất (nếu có)
                wait.until(d -> {
                    try {
                        Object result = ((JavascriptExecutor) d).executeScript(
                                "let o = document.querySelector('.loading, .loader, .spinner, .backdrop');" +
                                        "return (o == null || o.style.display == 'none' || o.style.visibility == 'hidden');"
                        );
                        return Boolean.parseBoolean(result.toString());
                    } catch (Exception e) {
                        return true; // không có overlay => OK
                    }
                });

                // 4. Thực hiện click
                element.click();
                return; // thành công => thoát hàm

            } catch (Exception e) {

                // Nếu lần cuối vẫn lỗi => throw để test fail đúng
                if (attempt == retries) {
                    throw e;
                }

                // Retry sau 500ms
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
    }

    protected void type(By locator, String text) {
        int retries = 3;

        for (int attempt = 1; attempt <= retries; attempt++) {
            try {
                // 1. Chờ element hiển thị (visible)
                WebElement element = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                );

                // 2. Đảm bảo element ở trong vùng nhìn thấy (tránh bị header/footer che)
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);

                // 3. Chờ element có thể tương tác (enabled)
                if (!element.isEnabled()) {
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                }

                // 4. Clear giá trị cũ (nếu có) rồi nhập text mới
                element.clear();
                element.sendKeys(text);

                return; // thành công → thoát hàm

            } catch (Exception e) {
                // Nếu thử đủ số lần mà vẫn fail → ném lỗi ra cho test fail đúng
                if (attempt == retries) {
                    throw e;
                }

                // Đợi nhẹ 300ms rồi thử lại (tránh animation / transition)
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    protected void uploadFiles(By fileInputLocator, String... relativePaths) {
        try {
            // 1. Chờ input visible (dùng wait chung)
            WebElement fileInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(fileInputLocator)
            );

            // 2. Scroll vào view (fix lỗi React/Angular bị che)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center'});", fileInput);

            // 3. Build absolute paths theo OS
            String baseDir = System.getProperty("user.dir");

            List<String> absolutePaths = Arrays.stream(relativePaths)
                    .map(path -> Paths.get(baseDir, path).toAbsolutePath().toString())
                    .toList();

            // 4. Clear trước khi upload (đặc biệt Firefox)
            fileInput.clear();

            // 5. Gửi file (multiple = newline)
            fileInput.sendKeys(String.join("\n", absolutePaths));

        } catch (Exception e) {
            throw new RuntimeException("Failed to upload files.", e);
        }
    }

    protected void jsClick(By locator) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );

            // Scroll tránh bị che
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", element);

            // JS click
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);

        } catch (Exception e) {
            throw new RuntimeException("Failed to perform jsClick on: " + locator, e);
        }
    }

    protected String getText(By locator) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );

            String text = element.getText().trim();

            // Nếu getText() rỗng, thử lấy trong attribute value (input/textarea)
            if (text.isEmpty()) {
                text = element.getAttribute("value");
                return text != null ? text.trim() : "";
            }

            return text;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get text from: " + locator, e);
        }
    }

    protected void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // 1) Document readyState === "complete"
            wait.until(webDriver ->
                    ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState")
                            .equals("complete"));

            // 2) jQuery active requests = 0 (nếu có jQuery)
            wait.until(webDriver -> {
                try {
                    Object result = ((JavascriptExecutor) webDriver)
                            .executeScript("return window.jQuery != null && jQuery.active == 0");
                    return result != null && Boolean.parseBoolean(result.toString());
                } catch (Exception e) {
                    return true; // jQuery không tồn tại → cho pass
                }
            });

            // 3) Angular stable (nếu có Angular)
            wait.until(webDriver -> {
                try {
                    Object result = ((JavascriptExecutor) webDriver).executeScript(
                            "return window.getAllAngularTestabilities && " +
                                    "window.getAllAngularTestabilities()[0].isStable()");
                    return result != null && Boolean.parseBoolean(result.toString());
                } catch (Exception e) {
                    return true; // Không có Angular → pass
                }
            });

        } catch (Exception e) {
            throw new RuntimeException("Page did not fully load!", e);
        }
    }














}
