/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 **/

package com.dell.cpsd.paqx.dne.transformers;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit test for SDC Performance Profile Request Transformer
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
//TODO: Complete this
//@RunWith(MockitoJUnitRunner.class)
public class SdcPerformanceProfileRequestTransformerTest
{
    @Mock
    private ComponentIdsTransformer componentIdsTransformer;

    @Mock
    private DelegateExecution delegateExecution;

    private SdcPerformanceProfileRequestTransformer sdcPerformanceProfileRequestTransformer;

    @Before
    public void setup() throws Exception
    {
        sdcPerformanceProfileRequestTransformer = new SdcPerformanceProfileRequestTransformer(componentIdsTransformer);
    }
}