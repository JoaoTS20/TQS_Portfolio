package com.example.exercicio2;

import com.example.exercicio2.controller.CarController;
import com.example.exercicio2.entities.Car;
import com.example.exercicio2.services.CarManagerService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerMvcTest {
    @MockBean
    private CarManagerService carManagerService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void postCar_Test() throws Exception {
        when(carManagerService.save(any())).thenReturn(new Car("model 3", "tesla"));

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(JsonUtil.toJson(new Car("model 3", "tesla")))
                .when()
                .post("/api/cars")
                    .then()
                        .log().all().statusCode(201)
                        .body("model", is("model 3"))
                        .body("maker", is("tesla"));


        verify(carManagerService, times(1)).save(Mockito.any());
    }

    @Test
    public void getAllCars_Test() throws Exception {
        Car car1 = new Car("model 3", "tesla");
        Car car2 = new Car("class a", "mercedes");
        Car car3 = new Car("astra", "opel");
        List<Car> allCars = Arrays.asList(car1, car2, car3);

        given(carManagerService.getAllCars()).willReturn(allCars);

        RestAssuredMockMvc.given().auth().none().when().get("/api/cars").then()
                .log().all().statusCode(200)
                .body("$", hasSize(3))
                .body("[0].model", is(car1.getModel()))
                .body("[1].maker", is(car2.getMaker()))
                .body("[2].maker", is(car3.getMaker()));
        verify(carManagerService, VerificationModeFactory.times(1)).getAllCars();

    }

}
