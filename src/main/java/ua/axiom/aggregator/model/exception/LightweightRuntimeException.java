package ua.axiom.aggregator.model.exception;

/**
 * Fast exception, that does not have filled stacktrace, fast to instantiate
 */
public class LightweightRuntimeException extends RuntimeException {
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
