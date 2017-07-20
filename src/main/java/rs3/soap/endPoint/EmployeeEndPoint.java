package rs3.soap.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs3.soap.GetEmployeeRequest;
import rs3.soap.GetEmployeeResponse;
import rs3.soap.repositoryAdapter.SoapEmployeeRepositoryAdapter;

@Endpoint
public class EmployeeEndPoint {
    private static final String NAMESPACE_URI = "rs3/soap";

    @Autowired
    private SoapEmployeeRepositoryAdapter empRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmp(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(empRepository.findEmployeeFromXsd(request.getId()));
        return response;
    }
}