
/**
 * AppAcceptServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.ammob.communication.unicom;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
    /**
     *  AppAcceptServiceSkeleton java skeleton for the axisService
     */
    public class AppAcceptServiceSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param acceptCompleteNotifyReq 
             * @return acceptCompleteNotifyResp 
         */
        
                 public com.ammob.communication.unicom.AcceptCompleteNotifyResp acceptCompleteNotify
                  (
                  com.ammob.communication.unicom.AcceptCompleteNotifyReq acceptCompleteNotifyReq
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#acceptCompleteNotify");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param productUseAuthReq 
             * @return productUseAuthResp 
         */
        
                 public com.ammob.communication.unicom.ProductUseAuthResp productUseAuth
                  (
                  com.ammob.communication.unicom.ProductUseAuthReq productUseAuthReq
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#productUseAuth");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param userSyncReq 
             * @return userSyncResp 
         */
        
                 public com.ammob.communication.unicom.UserSyncResp userSync
                  (
                  com.ammob.communication.unicom.UserSyncReq userSyncReq
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#userSync");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param acceptReq 
             * @return acceptResp 
         */
        
                 public com.ammob.communication.unicom.AcceptResp accept
                  (
                  AcceptReq acceptReq
                  )
            {
                	 
                	 
                	 String resultXML = acceptReq.getAcceptReq();
                	 try {
						Document document = DocumentHelper.parseText(resultXML);
						
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
                	 System.out.println("AppAcceptServiceSkeleton.accept()"+resultXML);
                	 AcceptResp acceptResp = new AcceptResp();
                	 acceptResp.setAcceptResp("thank you~!");
                	 return acceptResp;
            }
     
    }
    