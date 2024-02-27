package base.logger;

import io.qameta.allure.Step;
import org.slf4j.*;

public class CustomLogger {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private LogType logType;

    /**
     * Записує повідомлення журнала з відповідним рівнем логу.
     * @param message повідомлення для запису
     */
    @Step("{message}")
    private void log(String message) {
        switch (logType) {
            case WARN:
                logger.warn(message);
            case ERROR:
                logger.error(message);
            default:
                logger.info(message);
        }
    }
    /**
     * Записує повідомлення журнала з рівнем INFO.
     * @param message повідомлення для запису
     * @param args аргументи, які вставляються у повідомлення
     */

    protected void logInfo(String message, Object... args) {
        logType = LogType.INFO;
        log(String.format(message, args));
    }

    private enum LogType {
        INFO, WARN, ERROR
    }
}
