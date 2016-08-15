package exceptions;

/**
 * Created by DotinSchool2 on 8/10/2016.
 */
public class DatabaseConnectionException extends Throwable {
    public DatabaseConnectionException(String message) {
        super(message);
    }
}
