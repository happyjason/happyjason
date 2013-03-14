
package com.vidyo.replay.apiservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.vidyo.replay.apiservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeneralFaultGeneralFault_QNAME = new QName("http://replay.vidyo.com/apiservice", "GeneralFault");
    private final static QName _OK_QNAME = new QName("http://replay.vidyo.com/apiservice", "OK");
    private final static QName _UpdateRecordRequestComments_QNAME = new QName("http://replay.vidyo.com/apiservice", "comments");
    private final static QName _UpdateRecordRequestLocked_QNAME = new QName("http://replay.vidyo.com/apiservice", "locked");
    private final static QName _UpdateRecordRequestRecordScope_QNAME = new QName("http://replay.vidyo.com/apiservice", "recordScope");
    private final static QName _UpdateRecordRequestPin_QNAME = new QName("http://replay.vidyo.com/apiservice", "pin");
    private final static QName _UpdateRecordRequestTags_QNAME = new QName("http://replay.vidyo.com/apiservice", "tags");
    private final static QName _AccessViolationFaultAccessViolationFault_QNAME = new QName("http://replay.vidyo.com/apiservice", "AccessViolationFault");
    private final static QName _ExceptionException_QNAME = new QName("http://replay.vidyo.com/apiservice", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.vidyo.replay.apiservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteRecordRequest }
     * 
     */
    public DeleteRecordRequest createDeleteRecordRequest() {
        return new DeleteRecordRequest();
    }

    /**
     * Create an instance of {@link AccessViolationFault }
     * 
     */
    public AccessViolationFault createAccessViolationFault() {
        return new AccessViolationFault();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link RecordsSearchResponse }
     * 
     */
    public RecordsSearchResponse createRecordsSearchResponse() {
        return new RecordsSearchResponse();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link RecordsByIdRequest }
     * 
     */
    public RecordsByIdRequest createRecordsByIdRequest() {
        return new RecordsByIdRequest();
    }

    /**
     * Create an instance of {@link RecordsSearchRequest }
     * 
     */
    public RecordsSearchRequest createRecordsSearchRequest() {
        return new RecordsSearchRequest();
    }

    /**
     * Create an instance of {@link GeneralFault }
     * 
     */
    public GeneralFault createGeneralFault() {
        return new GeneralFault();
    }

    /**
     * Create an instance of {@link UpdateRecordRequest }
     * 
     */
    public UpdateRecordRequest createUpdateRecordRequest() {
        return new UpdateRecordRequest();
    }

    /**
     * Create an instance of {@link RecordsResponse }
     * 
     */
    public RecordsResponse createRecordsResponse() {
        return new RecordsResponse();
    }

    /**
     * Create an instance of {@link UpdateRecordResponse }
     * 
     */
    public UpdateRecordResponse createUpdateRecordResponse() {
        return new UpdateRecordResponse();
    }

    /**
     * Create an instance of {@link DeleteRecordResponse }
     * 
     */
    public DeleteRecordResponse createDeleteRecordResponse() {
        return new DeleteRecordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "GeneralFault", scope = GeneralFault.class)
    public JAXBElement<Exception> createGeneralFaultGeneralFault(Exception value) {
        return new JAXBElement<Exception>(_GeneralFaultGeneralFault_QNAME, Exception.class, GeneralFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "OK")
    public JAXBElement<String> createOK(String value) {
        return new JAXBElement<String>(_OK_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "comments", scope = UpdateRecordRequest.class)
    public JAXBElement<String> createUpdateRecordRequestComments(String value) {
        return new JAXBElement<String>(_UpdateRecordRequestComments_QNAME, String.class, UpdateRecordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordLocked }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "locked", scope = UpdateRecordRequest.class)
    public JAXBElement<RecordLocked> createUpdateRecordRequestLocked(RecordLocked value) {
        return new JAXBElement<RecordLocked>(_UpdateRecordRequestLocked_QNAME, RecordLocked.class, UpdateRecordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordScopeUpdate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "recordScope", scope = UpdateRecordRequest.class)
    public JAXBElement<RecordScopeUpdate> createUpdateRecordRequestRecordScope(RecordScopeUpdate value) {
        return new JAXBElement<RecordScopeUpdate>(_UpdateRecordRequestRecordScope_QNAME, RecordScopeUpdate.class, UpdateRecordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "pin", scope = UpdateRecordRequest.class)
    public JAXBElement<String> createUpdateRecordRequestPin(String value) {
        return new JAXBElement<String>(_UpdateRecordRequestPin_QNAME, String.class, UpdateRecordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "tags", scope = UpdateRecordRequest.class)
    public JAXBElement<String> createUpdateRecordRequestTags(String value) {
        return new JAXBElement<String>(_UpdateRecordRequestTags_QNAME, String.class, UpdateRecordRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "AccessViolationFault", scope = AccessViolationFault.class)
    public JAXBElement<Exception> createAccessViolationFaultAccessViolationFault(Exception value) {
        return new JAXBElement<Exception>(_AccessViolationFaultAccessViolationFault_QNAME, Exception.class, AccessViolationFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://replay.vidyo.com/apiservice", name = "Exception", scope = Exception.class)
    public JAXBElement<Object> createExceptionException(Object value) {
        return new JAXBElement<Object>(_ExceptionException_QNAME, Object.class, Exception.class, value);
    }

}
