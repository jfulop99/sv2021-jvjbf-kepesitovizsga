package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class RecorderNotFoundException extends AbstractThrowableProblem {
    public RecorderNotFoundException(URI uri, String message) {
        super(uri, message, Status.NOT_FOUND, message);
    }
}
