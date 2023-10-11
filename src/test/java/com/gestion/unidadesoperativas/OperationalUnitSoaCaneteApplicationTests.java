package com.gestion.unidadesoperativas;

import com.gestion.unidadesoperativas.domain.model.OperationalUnit;
import com.gestion.unidadesoperativas.repository.OperationalUnitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import java.util.List;



@SpringBootTest
@AutoConfigureWebTestClient
class OperationalUnitSoaCaneteApplicationTests {
    @Autowired
    OperationalUnitRepository operationalUnitRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateOperationalUnit() {
        OperationalUnit funcionary = new OperationalUnit(
                "testeoName",
                "testeoDirector",
                "960847347",
                "testeoAdress",
                "testeoDepartment",
                "A");

        webTestClient.post()
                .uri("/ms-soa")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(funcionary), OperationalUnit.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(OperationalUnit.class)
                .value(OperationalUnit::getId, notNullValue())
                .value(OperationalUnit::getName, equalTo("testeoName"))
                .value(OperationalUnit::getDirector, equalTo("testeoDirector"))
                .value(OperationalUnit::getTelephone, equalTo("960847347"))
                .value(OperationalUnit::getAddress, equalTo("testeoAdress"))
                .value(OperationalUnit::getDepartment, equalTo("testeoDepartment"))
                .value(OperationalUnit::getActive, equalTo("A"));
    }

    @Test
    public void testListOperatinalUnit() {
        webTestClient.get().uri("/ms-soa/listData")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(OperationalUnit.class)
                .consumeWith(response -> {
                    List<OperationalUnit> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertFalse(false, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });


    }

    @Test
    public void testListInactiveLegalGuardian() {
        webTestClient.get().uri("/ms-soa/listData/inactive")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(OperationalUnit.class)
                .consumeWith(response -> {
                    List<OperationalUnit> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });

    }

    @Test
    public void testListActiveLegalGuardian() {
        webTestClient.get().uri("/ms-soa/listData/active")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(OperationalUnit.class)
                .consumeWith(response -> {
                    List<OperationalUnit> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });

    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    public void testUpdateFuncionary(int dataId) {
        OperationalUnit UpdateFuncionary = new OperationalUnit(
                "testeoNameUpdate",
                "testeoDirectorUpdate",
                "960847347",
                "testeoAdressUpdate",
                "testeoDepartmentUpdate",
                "A");

        webTestClient.put().uri("/ms-soa/{id}", dataId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UpdateFuncionary)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(OperationalUnit.class)
                .consumeWith(response -> {
                });
    }
}
