/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.api;

/**
 * Provides a license.
 *
 * @author Christian Schlichtherle
 */
public interface LicenseProvider {

    /** Returns the license. */
    License license();
}