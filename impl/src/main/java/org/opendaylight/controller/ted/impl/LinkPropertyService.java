/*
 * Copyright © 2017 BNI, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.ted.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;

public interface LinkPropertyService {



    public Map<Short,Long> getLogicalTopo();
    
    //public Set<Map<Long,List<Long>>> getCoMPTopo();


    public Map<Short,NodeConnectorRef> getNodeMapIngress();

    public Set<Map<Short,List<Integer>>> getPhysicalTopo();
     
    public Map<Short,List<Integer>> getBBUResource();
    
    public Map<Short,Long> getNEResource();

    public Map<Short,List<Integer>> getWSSResource();
    
    public Map<Short,List<Integer>> getRRUResource();
    
}