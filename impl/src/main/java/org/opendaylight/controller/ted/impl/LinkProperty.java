/*
 * Copyright © 2017 BNI, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.ted.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbufeaturereply.rev170705.PacketBbuFeatureReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rrufeaturereply.rev170705.PacketRruFeatureReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swfeaturereply.rev170705.PacketSwFeatureReply;

import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.bbuconfigreply.rev170705.PacketBbuConfigReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.rruconfigreply.rev170705.PacketRruConfigReply;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.swconfigreply.rev170705.PacketSwConfigReply;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LinkProperty implements  LinkPropertyService {

    private static final Logger LOG = LoggerFactory.getLogger(LinkProperty.class);

    private static Set<Map<Short,List<Integer>>> physicalTopo = new HashSet<Map<Short,List<Integer>>>();
    private static Map<Short,List<Integer>> bbu_Resource = new HashMap<Short,List<Integer>>();
    private static Map<Short,Long> ne_Resource = new HashMap<Short,Long>();
    private static Map<Short,List<Integer>> wss_Resource = new HashMap<Short,List<Integer>>();
    private static Map<Short,List<Integer>> rru_Resource = new HashMap<Short,List<Integer>>();
    private static Map<Short,NodeConnectorRef> nodeMapIngress = new HashMap<Short,NodeConnectorRef>();   
    private static Map<Short,Long> logicalTopo = new HashMap<Short,Long>();

    public LinkProperty(){}

    public void swlinkHandler(PacketSwFeatureReply replyBody){
        
        LOG.info("------swlinkHandler begin----------{}",replyBody);
        NodeConnectorRef ingress = replyBody.getIngress();
        LOG.info("------neingress ----------{}",ingress);
        java.lang.Short node_ID = replyBody.getSwId();
        LOG.info("------------------------------swid------------------------------------{}"+node_ID);
        java.lang.Short switch_status = replyBody.getSwitchStatus();
        nodeMapIngress.put(node_ID,ingress);

        java.lang.Integer temp1 = replyBody.getConnectIdPort1();
        java.lang.Integer temp2 = replyBody.getConnectIdPort2();
        java.lang.Integer temp3 = replyBody.getConnectIdPort3();
        java.lang.Integer temp4 = replyBody.getConnectIdPort4();
        java.lang.Integer temp5 = replyBody.getConnectIdPort5();
        java.lang.Integer temp6 = replyBody.getConnectIdPort6();

        java.lang.Integer sw_dev1_id = (temp1 >> 12) & 0x000f;
        java.lang.Integer sw_dev1_port = (temp1 >> 8) & 0x000f;
        java.lang.Integer sw_channel1 = temp1 & 0x00ff;

        java.lang.Integer sw_dev2_id = (temp2 >> 12) & 0x000f;
        java.lang.Integer sw_dev2_port = (temp2 >> 8) & 0x000f;
        java.lang.Integer sw_channel2 = temp2 & 0x00ff;

        java.lang.Integer sw_dev3_id = (temp3 >> 12) & 0x000f;
        java.lang.Integer sw_dev3_port = (temp3 >> 8) & 0x000f;
        java.lang.Integer sw_channel3 = temp3 & 0x00ff;

        java.lang.Integer sw_dev4_id = (temp4 >> 12) & 0x000f;
        java.lang.Integer sw_dev4_port = (temp4 >> 8) & 0x000f;
        java.lang.Integer sw_channel4 = temp4 & 0x00ff;

        java.lang.Integer sw_dev5_id = (temp5 >> 12) & 0x000f;
        java.lang.Integer sw_dev5_port = (temp5 >> 8) & 0x000f;
        java.lang.Integer sw_channel5 = temp5 & 0x00ff;

        java.lang.Integer sw_dev6_id = (temp6 >> 12) & 0x000f;
        java.lang.Integer sw_dev6_port = (temp6 >> 8) & 0x000f;
        java.lang.Integer sw_channel6 = temp6 & 0x00ff;

        if(node_ID >= 12 && node_ID <= 15) {

            if(sw_dev1_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(1);
                link.add(sw_dev1_id);
                link.add(sw_dev1_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            }

            if(sw_dev2_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(2);
                link.add(sw_dev2_id);
                link.add(sw_dev2_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            }

            if(sw_dev3_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(3);
                link.add(sw_dev3_id);
                link.add(sw_dev3_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            }

            if(sw_dev4_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(4);
                link.add(sw_dev4_id);
                link.add(sw_dev4_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            }

            if(sw_dev5_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(5);
                link.add(sw_dev5_id);
                link.add(sw_dev5_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            }

            if(sw_dev6_id > node_ID){
                List<Integer> link = new ArrayList<Integer>();
                link.add(6);
                link.add(sw_dev6_id);
                link.add(sw_dev6_port);
                link.add(10);
                link.add(1550);
                Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
                physicalLinks.put(node_ID,link);
                physicalTopo.add(physicalLinks);
            } 
        }
        

        List<Integer> resource = new ArrayList<Integer>();
        resource.add(sw_channel1);
        resource.add(sw_channel2);
        resource.add(sw_channel3);
        resource.add(sw_channel4);
        resource.add(sw_channel5);
        resource.add(sw_channel6);
        
        if(node_ID >= 12 && node_ID <= 15) {
            ne_Resource.put(node_ID,63L);
        }
        if(node_ID >= 8 && node_ID <= 11) {
            wss_Resource.put(node_ID,resource);
        }
        LOG.info("------swlinkHandler end----------");
        
    }

    public void bbulinkHandler(PacketBbuFeatureReply replyBody){
               
        LOG.info("------bbulinkHandler start----------");
        NodeConnectorRef ingress = replyBody.getIngress();
        LOG.info("------neingress ----------{}",ingress);
        java.lang.Short node_ID = replyBody.getBbuId();
        LOG.info("-----------------------------------bbuid-----------------------------------{}"+node_ID);
        
        nodeMapIngress.put(node_ID,ingress);

        java.lang.Integer temp = replyBody.getConnectIdPort();
        
        java.lang.Integer bbu_dev1_id = (temp >> 4) & 0x000f;
        java.lang.Integer bbu_dev1_port = (temp) & 0x000f;

        java.lang.Integer bbu_dev2_id = (temp >> 12) & 0x000f;
        java.lang.Integer bbu_dev2_port = (temp >> 8) & 0x000f;

        if(bbu_dev1_id > node_ID){
            List<Integer> link = new ArrayList<Integer>();
            link.add(1);
            link.add(bbu_dev1_id);
            link.add(bbu_dev1_port);
            link.add(10);
            link.add(1550);
            Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
            physicalLinks.put(node_ID,link);
            physicalTopo.add(physicalLinks);
        }

        if(bbu_dev2_id > node_ID){
            List<Integer> link = new ArrayList<Integer>();
            link.add(2);
            link.add(bbu_dev2_id);
            link.add(bbu_dev2_port);
            link.add(10);
            link.add(1550);
            Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
            physicalLinks.put(node_ID,link);
            physicalTopo.add(physicalLinks);
        }

        List<Integer> resource = new ArrayList<Integer>();
        resource.add(replyBody.getLoadStatus().intValue());
        resource.add(replyBody.getParameter());
        resource.add(replyBody.getChannelNumber());

        bbu_Resource.put(node_ID,resource);
        

        LOG.info("------bbulinkHandler end----------");              
    }

    public void rrulinkHandler(PacketRruFeatureReply replyBody){
               
        LOG.info("------rrulinkHandler start----------");
        NodeConnectorRef ingress = replyBody.getIngress();
        LOG.info("------neingress ----------{}",ingress);
        java.lang.Short node_ID = replyBody.getRruId();
        LOG.info("-----------------------------------rruid-----------------------------------{}"+node_ID);
        nodeMapIngress.put(node_ID,ingress);

        java.lang.Short temp = replyBody.getConnectIdPort();
        
        java.lang.Integer rru_dev_id = Integer.valueOf(((temp >> 4) & 0x0f)).intValue();
        java.lang.Integer rru_dev_port = Integer.valueOf((temp & 0x0f)).intValue();


        if(rru_dev_id > node_ID){
            List<Integer> link = new ArrayList<Integer>();
            link.add(1);
            link.add(rru_dev_id);
            link.add(rru_dev_port);
            link.add(10);
            link.add(1550);
            Map<Short,List<Integer>> physicalLinks =  new HashMap<Short,List<Integer>>();
            physicalLinks.put(node_ID,link);
            physicalTopo.add(physicalLinks);
        }
        
        //logicalTopo.put(node_ID,replyBody.getTargetBbuId());

        List<Integer> resource = new ArrayList<Integer>();
        //resource.add(new Integer((replyBody.getTargetBbuId()).intValue()));
        resource.add(Integer.valueOf(replyBody.getCompStatus()).intValue());
        resource.add(new Integer((replyBody.getCompTraffic()).intValue()));
        resource.add(new Integer((replyBody.getTotalTraffic()).intValue()));
        resource.add(Integer.valueOf(replyBody.getChannelNumber()).intValue());

        rru_Resource.put(node_ID,resource);
        
        LOG.info("------rrulinkHandler end----------");              
    }

    public void rrulinkUpdateHandler(PacketRruConfigReply replyBody){
               
        LOG.info("------rrulinkUpdateHandler start----------");

        java.lang.Long temp = (replyBody.getResult() >> 16) & 0x0000000f;
        java.lang.Short node_ID = new Short(temp.shortValue());
        java.lang.Long targetbbuid = (replyBody.getResult()) & 0x0000000f;
        //logicalTopo.remove(node_ID);
        logicalTopo.put(node_ID,targetbbuid);
        
        LOG.info("------rrulinkUpdateHandler end----------");              
    }

    public void display(){
        LOG.info("------physicalTopo display----------{}"+physicalTopo);
        LOG.info("------physicalTopo size display----------{}"+physicalTopo.size());
        LOG.info("------bbu_Resource display----------{}"+bbu_Resource.size());
        LOG.info("------rrh_Resource display----------{}"+rru_Resource.size());
        LOG.info("------ne_Resource display----------{}"+ne_Resource.size());
        LOG.info("------wss_Resource display----------{}"+wss_Resource.size());
        LOG.info("------logicalTopo display----------{}"+logicalTopo);
    }

    @Override
    public Map<Short,NodeConnectorRef> getNodeMapIngress(){
        LOG.info("=========TEd linkproperty:nodeMapIngress====={}");
        return nodeMapIngress;
    }
    @Override
    public Set<Map<Short,List<Integer>>> getPhysicalTopo(){
        return physicalTopo;
    }
    @Override
    public Map<Short,List<Integer>> getBBUResource() {
        return bbu_Resource;
    }
    @Override
    public Map<Short,Long> getNEResource() {
        return ne_Resource;
    }
    public Map<Short,List<Integer>> getWSSResource() {
        return wss_Resource;
    }
    @Override
    public Map<Short,List<Integer>> getRRUResource() {
        return rru_Resource;
    }
    @Override
    public Map<Short,Long> getLogicalTopo() {
        return logicalTopo;
    }
}

