/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries.  All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 **/

package com.dell.cpsd.paqx.dne.transformers;

import com.dell.cpsd.paqx.dne.domain.scaleio.ScaleIOData;
import com.dell.cpsd.paqx.dne.repository.DataServiceRepository;
import com.dell.cpsd.paqx.dne.service.model.ComponentEndpointIds;
import com.dell.cpsd.virtualization.capabilities.api.SoftwareVIBRequestMessage;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.dell.cpsd.paqx.dne.service.delegates.utils.DelegateConstants.HOSTNAME;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Test class for SoftwareVibRequestTransformer
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved.
 * Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class SoftwareVibRequestTransformerTest
{
    @Mock
    private DataServiceRepository dataServiceRepository;

    @Mock
    private ComponentIdsTransformer componentIdsTransformer;

    @Mock
    private DelegateExecution delegateExecution;

    @Mock
    private ComponentEndpointIds componentEndpointIds;

    @Mock
    private ScaleIOData scaleIOData;

    private SoftwareVibRequestTransformer softwareVibRequestTransformer;

    private final        String remoteVibUrl          = "https://remote.vib.url";
    private final        String hostname              = "host.name";
    private static final String VCENTER_CUSTOMER_TYPE = "VCENTER-CUSTOMER";

    @Before
    public void setup() throws Exception
    {
        softwareVibRequestTransformer = new SoftwareVibRequestTransformer(dataServiceRepository, remoteVibUrl, componentIdsTransformer);
    }

    @Test
    public void testBuildInstallSoftwareVibRequest() throws Exception
    {
        when(delegateExecution.getVariable(HOSTNAME)).thenReturn(hostname);
        when(componentIdsTransformer.getVCenterComponentEndpointIdsByEndpointType(VCENTER_CUSTOMER_TYPE)).thenReturn(componentEndpointIds);

        final SoftwareVIBRequestMessage softwareVIBRequestMessage = softwareVibRequestTransformer
                .buildInstallSoftwareVibRequest(delegateExecution);

        assertNotNull(softwareVIBRequestMessage);

        assertNotNull(softwareVIBRequestMessage.getComponentEndpointIds());
        assertNotNull(softwareVIBRequestMessage.getSoftwareVibInstallRequest());
        assertNotNull(softwareVIBRequestMessage.getCredentials());
    }

    //TODO: Complete rest of them
}