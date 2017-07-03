/*
 * Copyright © 2017 BNI, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.ted.impl;

import org.opendaylight.controller.md.sal.binding.api.NotificationPublishService;
import org.opendaylight.controller.md.sal.binding.api.NotificationService;

import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.NotificationListener;


import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TedProvider {

    private static final Logger LOG = LoggerFactory.getLogger(TedProvider.class);

    private final DataBroker dataBroker;

    private final NotificationPublishService notificationPublishService;
    private final NotificationService notificationService;

    private ListenerRegistration<NotificationListener> registration = null;

    public TedProvider(final DataBroker dataBroker,
            final NotificationPublishService notificationPublishService,
            final NotificationService notificationService ) {

        this.dataBroker = dataBroker;
        this.notificationPublishService = notificationPublishService;
        this.notificationService = notificationService;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("TedProvider Session Initiated");
        if (notificationService != null) {
            //LOG.info("NotificationService is: " + notificationService.toString());
            LinkProperty linkproperty = new LinkProperty();
            registration = notificationService.registerNotificationListener(linkproperty);
        }

    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {

        LOG.info("TedProvider Closed");

        if( registration != null){
            registration.close();           
        }
    }
}
