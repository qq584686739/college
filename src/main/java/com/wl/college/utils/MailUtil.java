package com.wl.college.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created by yugoh on 2017/5/26.
 */
public class MailUtil {

    private static final String REGION_ID = "cn-hangzhou";
//    private static final String ACCESS_KEY = "LTAI5sU1KXsTPYah";
    private static final String ACCESS_KEY = "LTAIljZ2IhjGh8b1";
//    private static final String ACCESS_SECRET = "iPHBp9ygcfknw2qjK9CejgtzT9CbvH";
    private static final String ACCESS_SECRET = "FR6LkpdmiJEFEnakdFTm0qyC3dfFGf";
    private static final String ACCOUNT_NAME = "college@support.wisdomlucky.com";
    private static final String ACCOUNT_ALIAS = "college";
    private static final int ADDRESS_TYPE = 1;

    public static void send(boolean replyToAddress, String toAddress, String subject, String tagName, String htmlBody) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        request.setAccountName(ACCOUNT_NAME);
        request.setFromAlias(ACCOUNT_ALIAS);
        request.setAddressType(ADDRESS_TYPE);
        request.setTagName(tagName);
        request.setReplyToAddress(replyToAddress);
        request.setToAddress(toAddress);
        request.setSubject(subject);
        request.setHtmlBody(htmlBody);
        SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        System.out.println(httpResponse.getEnvId());
        System.out.println(httpResponse.getRequestId());
    }
}
