package rs3.soap.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs3.soap.GetDepartmentRequest;
import rs3.soap.GetDepartmentResponse;
import rs3.soap.repositoryAdapter.SoapDepartmentRepositoryAdapter;

@Endpoint
public class DepartmentEndPoint {
    private static final String NAMESPACE_URI = "rs3/soap";

    @Autowired
    private SoapDepartmentRepositoryAdapter depRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDepartmentRequest")
    @ResponsePayload
    public GetDepartmentResponse getDep(@RequestPayload GetDepartmentRequest request) {
        GetDepartmentResponse response = new GetDepartmentResponse();
        response.setDepartment(depRepository.findDepartmentFromXsd(request.getId()));

        return response;
    }
}