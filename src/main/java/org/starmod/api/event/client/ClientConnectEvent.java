/*
 * This file is part of StarModAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) StarModAPI <http://starmod.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.starmod.api.event.client;

import org.starmod.api.Client;

public class ClientConnectEvent extends ClientEvent {

    private final Result result;

    public ClientConnectEvent(final Client client, final Result result) {
        super(client);
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public static enum Result {

        SUCCESS(0),

        ERROR_GENERAL(-1),
        ERROR_LOGGED_IN(-2),
        ERROR_ACCESS_DENIED(-3),
        ERROR_FULL(-4),
        ERROR_VERSION(-5),
        ERROR_BANNED(-6),
        ERROR_AUTH_FAIL(-7),
        ERROR_WHITELIST(-8),
        ERROR_USERNAME(-9),
        ERROR_REQUIRED_AUTH(-10),
        ERROR_ADMIN(-11);


        private final int code;

        private Result(final int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Result getFromCode(final int code) {
            for (Result r : values()) {
                if (r.getCode() == code)
                    return r;
            }
            return null;
        }

    }

}
