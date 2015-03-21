package jalse.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is a simple yet fully-featured implementation of {@link MutableActionBindings}.<br>
 * <br>
 * Keys cannot be null or empty.
 *
 * @author Elliot Ford
 *
 */
@SuppressWarnings("unchecked")
public class DefaultActionBindings implements MutableActionBindings {

    private static void validateKey(final String key) {
	if (key == null || key.length() == 0) {
	    throw new IllegalArgumentException();
	}
    }

    private final Map<String, Object> bindings;

    /**
     * Creates a new instance of DefaultActionBindings with no bound values.
     */
    public DefaultActionBindings() {
	this((Map<String, ?>) null);
    }

    /**
     * Creates a new instance of DefaultActionBindings with the supplied source bindings.
     *
     * @param sourceBindings
     *            Source bindings to shallow copy.
     */
    public DefaultActionBindings(final ActionBindings sourceBindings) {
	this(sourceBindings.toMap());
    }

    /**
     * Creates a new instance of AbstractEngineBindings with the supplied key-value pairs.
     *
     * @param bindings
     *            Key-value pairs to bind (can be {@code null}).
     */
    protected DefaultActionBindings(final Map<String, ?> bindings) {
	this.bindings = new ConcurrentHashMap<>();
	if (bindings != null) {
	    this.bindings.putAll(bindings);
	}
    }

    @Override
    public <T> T get(final String key) {
	validateKey(key);
	return (T) bindings.get(key);
    }

    @Override
    public <T> T put(final String key, final T value) {
	validateKey(key);
	return (T) bindings.put(key, Objects.requireNonNull(value));
    }

    @Override
    public <T> T remove(final String key) {
	validateKey(key);
	return (T) bindings.remove(key);
    }

    @Override
    public Map<String, ?> toMap() {
	return new HashMap<>(bindings);
    }
}
