
/**
 * AppAcceptServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.ammob.communication.unicom;

        /**
        *  AppAcceptServiceMessageReceiverInOut message receiver
        */

        public class AppAcceptServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        AppAcceptServiceSkeleton skel = (AppAcceptServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("acceptCompleteNotify".equals(methodName)){
                
                com.ammob.communication.unicom.AcceptCompleteNotifyResp acceptCompleteNotifyResp1 = null;
	                        com.ammob.communication.unicom.AcceptCompleteNotifyReq wrappedParam =
                                                             (com.ammob.communication.unicom.AcceptCompleteNotifyReq)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.ammob.communication.unicom.AcceptCompleteNotifyReq.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               acceptCompleteNotifyResp1 =
                                                   
                                                   
                                                         skel.acceptCompleteNotify(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), acceptCompleteNotifyResp1, false, new javax.xml.namespace.QName("http://www.bnet.cn/v3.0/",
                                                    "acceptCompleteNotify"));
                                    } else 

            if("productUseAuth".equals(methodName)){
                
                com.ammob.communication.unicom.ProductUseAuthResp productUseAuthResp3 = null;
	                        com.ammob.communication.unicom.ProductUseAuthReq wrappedParam =
                                                             (com.ammob.communication.unicom.ProductUseAuthReq)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.ammob.communication.unicom.ProductUseAuthReq.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               productUseAuthResp3 =
                                                   
                                                   
                                                         skel.productUseAuth(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), productUseAuthResp3, false, new javax.xml.namespace.QName("http://www.bnet.cn/v3.0/",
                                                    "productUseAuth"));
                                    } else 

            if("userSync".equals(methodName)){
                
                com.ammob.communication.unicom.UserSyncResp userSyncResp5 = null;
	                        com.ammob.communication.unicom.UserSyncReq wrappedParam =
                                                             (com.ammob.communication.unicom.UserSyncReq)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.ammob.communication.unicom.UserSyncReq.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               userSyncResp5 =
                                                   
                                                   
                                                         skel.userSync(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), userSyncResp5, false, new javax.xml.namespace.QName("http://www.bnet.cn/v3.0/",
                                                    "userSync"));
                                    } else 

            if("accept".equals(methodName)){
                
                com.ammob.communication.unicom.AcceptResp acceptResp7 = null;
	                        com.ammob.communication.unicom.AcceptReq wrappedParam =
                                                             (com.ammob.communication.unicom.AcceptReq)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.ammob.communication.unicom.AcceptReq.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               acceptResp7 =
                                                   
                                                   
                                                         skel.accept(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), acceptResp7, false, new javax.xml.namespace.QName("http://www.bnet.cn/v3.0/",
                                                    "accept"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.AcceptCompleteNotifyReq param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.AcceptCompleteNotifyReq.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.AcceptCompleteNotifyResp param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.AcceptCompleteNotifyResp.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.ProductUseAuthReq param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.ProductUseAuthReq.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.ProductUseAuthResp param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.ProductUseAuthResp.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.UserSyncReq param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.UserSyncReq.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.UserSyncResp param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.UserSyncResp.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.AcceptReq param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.AcceptReq.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ammob.communication.unicom.AcceptResp param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ammob.communication.unicom.AcceptResp.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ammob.communication.unicom.AcceptCompleteNotifyResp param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.ammob.communication.unicom.AcceptCompleteNotifyResp.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.ammob.communication.unicom.AcceptCompleteNotifyResp wrapacceptCompleteNotify(){
                                com.ammob.communication.unicom.AcceptCompleteNotifyResp wrappedElement = new com.ammob.communication.unicom.AcceptCompleteNotifyResp();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ammob.communication.unicom.ProductUseAuthResp param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.ammob.communication.unicom.ProductUseAuthResp.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.ammob.communication.unicom.ProductUseAuthResp wrapproductUseAuth(){
                                com.ammob.communication.unicom.ProductUseAuthResp wrappedElement = new com.ammob.communication.unicom.ProductUseAuthResp();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ammob.communication.unicom.UserSyncResp param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.ammob.communication.unicom.UserSyncResp.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.ammob.communication.unicom.UserSyncResp wrapuserSync(){
                                com.ammob.communication.unicom.UserSyncResp wrappedElement = new com.ammob.communication.unicom.UserSyncResp();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ammob.communication.unicom.AcceptResp param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.ammob.communication.unicom.AcceptResp.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.ammob.communication.unicom.AcceptResp wrapaccept(){
                                com.ammob.communication.unicom.AcceptResp wrappedElement = new com.ammob.communication.unicom.AcceptResp();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.ammob.communication.unicom.AcceptCompleteNotifyReq.class.equals(type)){
                
                           return com.ammob.communication.unicom.AcceptCompleteNotifyReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.AcceptCompleteNotifyResp.class.equals(type)){
                
                           return com.ammob.communication.unicom.AcceptCompleteNotifyResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.ProductUseAuthReq.class.equals(type)){
                
                           return com.ammob.communication.unicom.ProductUseAuthReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.ProductUseAuthResp.class.equals(type)){
                
                           return com.ammob.communication.unicom.ProductUseAuthResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.UserSyncReq.class.equals(type)){
                
                           return com.ammob.communication.unicom.UserSyncReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.UserSyncResp.class.equals(type)){
                
                           return com.ammob.communication.unicom.UserSyncResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.AcceptReq.class.equals(type)){
                
                           return com.ammob.communication.unicom.AcceptReq.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ammob.communication.unicom.AcceptResp.class.equals(type)){
                
                           return com.ammob.communication.unicom.AcceptResp.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    