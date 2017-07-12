/*
 * Copyright © 2017 BNI, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.ted.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swfeaturereply.rev170705.PacketSwFeatureReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swfeaturereply.rev170705.PacketSwFeatureReplyListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbufeaturereply.rev170705.PacketBbuFeatureReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbufeaturereply.rev170705.PacketBbuFeatureReplyListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rrufeaturereply.rev170705.PacketRruFeatureReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rrufeaturereply.rev170705.PacketRruFeatureReplyListener;

import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbuconfigreply.rev170705.PacketBbuConfigReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbuconfigreply.rev170705.PacketBbuConfigReplyListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rruconfigreply.rev170705.PacketRruConfigReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rruconfigreply.rev170705.PacketRruConfigReplyListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swconfigreply.rev170705.PacketSwConfigReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swconfigreply.rev170705.PacketSwConfigReplyListener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;



public class TedHandler implements PacketSwFeatureReplyListener,PacketBbuFeatureReplyListener,PacketRruFeatureReplyListener,
PacketBbuConfigReplyListener,PacketRruConfigReplyListener,PacketSwConfigReplyListener {

    private static final Logger LOG = LoggerFactory.getLogger(TedHandler.class);

	public LinkProperty linkProperty = new LinkProperty();

    @Override
    public void onPacketSwFeatureReply(PacketSwFeatureReply notification){
    	LOG.info("========hp TedHandler onPacketSwFeatureReply-{}",notification);
    	linkProperty.swlinkHandler(notification);
        linkProperty.display();
    }

    @Override
    public void onPacketBbuFeatureReply(PacketBbuFeatureReply notification){
    	LOG.info("========hp TedHandler onPacketBbuFeatureReply-{}",notification);
    	linkProperty.bbulinkHandler(notification);
        linkProperty.display();
    }

    @Override
    public void onPacketRruFeatureReply(PacketRruFeatureReply notification){
    	LOG.info("========hp TedHandler onPacketRruFeatureReply-{}",notification);
    	linkProperty.rrulinkHandler(notification);
        linkProperty.display();
    }

    @Override
    public void onPacketBbuConfigReply(PacketBbuConfigReply notification){
        
    }

    @Override
    public void onPacketSwConfigReply(PacketSwConfigReply notification){
    }

    @Override
    public void onPacketRruConfigReply(PacketRruConfigReply notification){
        LOG.info("========hp TedHandler onPacketRruConfigReply-{}",notification);
        linkProperty.rrulinkUpdateHandler(notification);
        linkProperty.display();
    }
}