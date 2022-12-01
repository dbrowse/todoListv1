package contracts

import com.github.tomakehurst.wiremock.http.HttpHeader
import org.apache.http.HttpHeaders
import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.MediaType

Contract.make {
    description"should return all customers"

    request {
        url "/customer"
        method GET()


    }
    response {
        status 200
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        }
        body( [[id: 1L, name: "Jane"], [id:2L, name: "Bob"]])
    }
}