/*
 * Copyright 2013 Opencard Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.openpay.client.core.operations;

import static mx.openpay.client.utils.OpenpayPathComponents.FEES;
import static mx.openpay.client.utils.OpenpayPathComponents.MERCHANT_ID;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import mx.openpay.client.Fee;
import mx.openpay.client.core.JsonServiceClient;
import mx.openpay.client.core.requests.transactions.CreateFeeParams;
import mx.openpay.client.exceptions.OpenpayServiceException;
import mx.openpay.client.exceptions.ServiceUnavailableException;
import mx.openpay.client.utils.SearchParams;

/**
 * @author elopez
 */
public class FeeOperations extends ServiceOperations {

    private static final String FEES_PATH = MERCHANT_ID + FEES;

    public FeeOperations(final JsonServiceClient client, final String merchantId) {
        super(client, merchantId);
    }

    public Fee create(final CreateFeeParams params) throws OpenpayServiceException, ServiceUnavailableException {
        String path = String.format(FEES_PATH, this.getMerchantId());
        return this.getJsonClient().post(path, params.asMap(), Fee.class);
    }

    public Fee create(final String customerId, final BigDecimal amount, final String description,
            final String orderId) throws ServiceUnavailableException, OpenpayServiceException {
        return this.create(new CreateFeeParams()
                .customerId(customerId)
                .amount(amount)
                .description(description)
                .orderId(orderId));
    }

    public List<Fee> list(final SearchParams params) throws ServiceUnavailableException,
            OpenpayServiceException {
        String path = String.format(FEES_PATH, this.getMerchantId());
        Map<String, String> map = params == null ? null : params.asMap();
        return this.getJsonClient().list(path, map, Fee.class);
    }

}
