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
package mx.openpay.client.core.requests.transactions;

import lombok.Getter;
import mx.openpay.client.core.requests.RequestBuilder;

/**
 * Parameters to refund a completed charge.
 * @author elopez
 */
public class RefundParams extends RequestBuilder {

    @Getter
    private String customerId;

    @Getter
    private String chargeId;

    /**
     * The ID of the customer to which the amount will be refunded. Optional, the refund will be for the merchant if not
     * specified.
     */
    public RefundParams customerId(final String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * The ID of the charge to refund. Required. The charge must belong to the merchant, or to the customer if the
     * customer id is set.
     */
    public RefundParams chargeId(final String chargeId) {
        this.chargeId = chargeId;
        return this;
    }

}
