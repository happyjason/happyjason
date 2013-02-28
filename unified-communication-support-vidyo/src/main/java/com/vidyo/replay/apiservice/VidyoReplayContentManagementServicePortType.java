package com.vidyo.replay.apiservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-01-05T14:59:40.449+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://replay.vidyo.com/apiservice", name = "VidyoReplayContentManagementServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface VidyoReplayContentManagementServicePortType {

    @WebResult(name = "RecordsSearchResponse", targetNamespace = "http://replay.vidyo.com/apiservice", partName = "parameter")
    @WebMethod(operationName = "RecordsSearch", action = "RecordsSearch")
    public RecordsSearchResponse recordsSearch(
        @WebParam(partName = "parameter", name = "RecordsSearchRequest", targetNamespace = "http://replay.vidyo.com/apiservice")
        RecordsSearchRequest parameter
    ) throws GeneralFault_Exception;

    @WebResult(name = "DeleteRecordResponse", targetNamespace = "http://replay.vidyo.com/apiservice", partName = "parameter")
    @WebMethod(operationName = "DeleteRecord", action = "DeleteRecord")
    public DeleteRecordResponse deleteRecord(
        @WebParam(partName = "parameter", name = "DeleteRecordRequest", targetNamespace = "http://replay.vidyo.com/apiservice")
        DeleteRecordRequest parameter
    ) throws GeneralFault_Exception, AccessViolationFault_Exception;

    @WebResult(name = "UpdateRecordResponse", targetNamespace = "http://replay.vidyo.com/apiservice", partName = "parameter")
    @WebMethod(operationName = "UpdateRecord", action = "UpdateRecord")
    public UpdateRecordResponse updateRecord(
        @WebParam(partName = "parameter", name = "UpdateRecordRequest", targetNamespace = "http://replay.vidyo.com/apiservice")
        UpdateRecordRequest parameter
    ) throws GeneralFault_Exception, AccessViolationFault_Exception;

    @WebResult(name = "RecordsResponse", targetNamespace = "http://replay.vidyo.com/apiservice", partName = "parameter")
    @WebMethod(operationName = "RecordsById", action = "RecordsById")
    public RecordsResponse recordsById(
        @WebParam(partName = "parameter", name = "RecordsByIdRequest", targetNamespace = "http://replay.vidyo.com/apiservice")
        RecordsByIdRequest parameter
    ) throws GeneralFault_Exception;
}
