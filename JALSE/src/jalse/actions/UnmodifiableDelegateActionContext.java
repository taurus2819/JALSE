package jalse.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

class UnmodifiableDelegateActionContext<T> implements MutableActionContext<T> {

    private final MutableActionContext<T> delegate;

    UnmodifiableDelegateActionContext(final MutableActionContext<T> delegate) {
	this.delegate = delegate;
    }

    @Override
    public void await() throws InterruptedException {
	if (delegate != null) {
	    delegate.await();
	}
    }

    @Override
    public boolean cancel() {
	return delegate != null ? delegate.cancel() : false;
    }

    @Override
    public <S> S get(final String key) {
	return delegate != null ? delegate.get(key) : null;
    }

    @Override
    public Action<T> getAction() {
	return delegate != null ? delegate.getAction() : null;
    }

    @Override
    public Optional<T> getActor() {
	return delegate != null ? delegate.getActor() : Optional.empty();
    }

    @Override
    public ActionEngine getEngine() {
	return delegate != null ? delegate.getEngine() : null;
    }

    @Override
    public long getInitialDelay(final TimeUnit unit) {
	return delegate != null ? delegate.getInitialDelay(unit) : 0L;
    }

    @Override
    public long getPeriod(final TimeUnit unit) {
	return delegate != null ? delegate.getPeriod(unit) : 0L;
    }

    @Override
    public boolean isCancelled() {
	return delegate != null ? delegate.isCancelled() : false;
    }

    @Override
    public boolean isDone() {
	return delegate != null ? delegate.isDone() : true;
    }

    @Override
    public <S> S put(final String key, final S value) {
	throw new UnsupportedOperationException();
    }

    @Override
    public <S> S remove(final String key) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void schedule() {
	throw new UnsupportedOperationException();
    }

    @Override
    public void scheduleAndAwait() throws InterruptedException {
	throw new UnsupportedOperationException();
    }

    @Override
    public void setActor(final T actor) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void setInitialDelay(final long initialDelay, final TimeUnit unit) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void setPeriod(final long period, final TimeUnit unit) {
	throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, ?> toMap() {
	return delegate != null ? delegate.toMap() : new HashMap<>();
    }
}
