package com.taass.ecommerce;

import com.taass.ecommerce.controller.OrderController;
import com.taass.ecommerce.controller.MusicDeviceController;
import com.taass.ecommerce.dto.OrderMusicDeviceDto;
import com.taass.ecommerce.model.Order;
import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EcommerceApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcommerceApplicationIntegrationTest {

    @Autowired private TestRestTemplate restTemplate;

    @LocalServerPort private int port;

    @Autowired private MusicDeviceController musicDeviceController;

    @Autowired private OrderController orderController;

    @Test
    public void contextLoads() {
        Assertions
          .assertThat(musicDeviceController)
          .isNotNull();
        Assertions
          .assertThat(orderController)
          .isNotNull();
    }

    @Test
    public void givenGetMusicDevicesApiCall_whenMusicDeviceListRetrieved_thenSizeMatchAndListContainsMusicDeviceNames() {
        ResponseEntity<Iterable<MusicDevice>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/musicDevices", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<MusicDevice>>() {
        });
        Iterable<MusicDevice> musicDevices = responseEntity.getBody();
        Assertions
          .assertThat(musicDevices)
          .hasSize(7);

        assertThat(musicDevices, hasItem(hasProperty("name", is("TV Set"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Game Console"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Sofa"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Icecream"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Beer"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Phone"))));
        assertThat(musicDevices, hasItem(hasProperty("name", is("Watch"))));
    }

    @Test
    public void givenGetOrdersApiCall_whenMusicDeviceListRetrieved_thenSizeMatchAndListContainsMusicDeviceNames() {
        ResponseEntity<Iterable<Order>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/orders", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Order>>() {
        });

        Iterable<Order> orders = responseEntity.getBody();
        Assertions
          .assertThat(orders)
          .hasSize(0);
    }

    @Test
    public void givenPostOrder_whenBodyRequestMatcherJson_thenResponseContainsEqualObjectProperties() {
        final ResponseEntity<Order> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", prepareOrderForm(), Order.class);
        Order order = postResponse.getBody();
        Assertions
          .assertThat(postResponse.getStatusCode())
          .isEqualByComparingTo(HttpStatus.CREATED);

        assertThat(order, hasProperty("status", is("PAID")));
        assertThat(order.getOrderMusicDevices(), hasItem(hasProperty("quantity", is(2))));
    }

    private OrderController.OrderForm prepareOrderForm() {
        OrderController.OrderForm orderForm = new OrderController.OrderForm();
        OrderMusicDeviceDto musicDeviceDto = new OrderMusicDeviceDto();
        musicDeviceDto.setMusicDevice(new MusicDevice(1L, "TV Set", 300.00, MusicDeviceCategories.MIDIProduction,"http://placehold.it/200x100",""));
        musicDeviceDto.setQuantity(2);
        orderForm.setMusicDeviceOrders(Collections.singletonList(musicDeviceDto));

        return orderForm;
    }
}
