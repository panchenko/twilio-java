package com.twilio.base;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;

import java.util.concurrent.CompletableFuture;

/**
 * Executor for deletes of a resource.
 *
 * @param <T> type of the resource
 */
public abstract class Deleter<T extends Resource> {

    /**
     * Execute an async request using default client.
     *
     * @return future that resolves to true if the object was deleted
     */
    public CompletableFuture<Boolean> async() {
        return async(Twilio.getRestClient());
    }

    /**
     * Execute an async request using specified client.
     *
     * @param client client used to make request
     * @return future that resolves to true if the object was deleted
     */
    public CompletableFuture<Boolean> async(final TwilioRestClient client) {
        return CompletableFuture.supplyAsync(() -> execute(client), Twilio.getExecutorService());
    }

    /**
     * Execute a request using default client.
     *
     * @return true if the object was deleted
     */
    public boolean execute() {
        return execute(Twilio.getRestClient());
    }

    /**
     * Execute a request using specified client.
     *
     * @param client client used to make request
     * @return true if the object was deleted
     */
    public abstract boolean execute(final TwilioRestClient client);
}
