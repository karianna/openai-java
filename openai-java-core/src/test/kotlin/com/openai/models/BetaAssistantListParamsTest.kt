// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaAssistantListParamsTest {

    @Test
    fun create() {
        BetaAssistantListParams.builder()
            .after("after")
            .before("before")
            .limit(0L)
            .order(BetaAssistantListParams.Order.ASC)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BetaAssistantListParams.builder()
                .after("after")
                .before("before")
                .limit(0L)
                .order(BetaAssistantListParams.Order.ASC)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("before", "before")
        expected.put("limit", "0")
        expected.put("order", BetaAssistantListParams.Order.ASC.toString())
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BetaAssistantListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
