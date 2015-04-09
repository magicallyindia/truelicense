/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.core.io;

import org.truelicense.api.io.Sink;
import org.truelicense.api.io.Source;
import org.truelicense.api.io.Store;

import java.io.*;
import javax.annotation.concurrent.Immutable;

/**
 * Provides a poor man's copy algorithm.
 * The implementation in this class is suitable for only small amounts of data,
 * say a few kilobytes.
 *
 * @author Christian Schlichtherle
 */
@Immutable
public final class Copy {

    private Copy() { }

    /*
     * Copies the data from the given source to the given sink.
     *
     * @param source the input source.
     * @param sink the output sink.
     */
    public static void copy(final Source source, final Sink sink)
    throws IOException {
        try (InputStream in = source.input();
             OutputStream out = sink.output()) {
            final byte[] buffer = new byte[Store.BUFSIZE];
            int read;
            while (0 <= (read = in.read(buffer)))
                out.write(buffer, 0, read);
        }
    }
}