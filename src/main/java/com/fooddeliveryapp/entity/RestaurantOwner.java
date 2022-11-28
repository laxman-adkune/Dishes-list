package com.fooddeliveryapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class RestaurantOwner {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long restaurantId;

        @NotNull(message = "Restaurant Name is mandatory")
        private String restaurantName;

        @NotNull(message = "Mobile Number is mandatory")
        private Long restaurantMobile;

        @NotNull(message = "First Name is mandatory")
        private String ownerFirstName;

        @NotNull(message = "Last Name is mandatory")
        private String ownerLastName;

        @NotNull(message = "City is mandatory")
        private String restaurantCity;

        @NotNull(message = "State is mandatory")
        private String restaurantState;

        @NotNull(message = "Pincode is mandatory")
        private Long restaurantPincode;

//        @OneToOne(cascade = CascadeType.ALL)
//        @JoinColumn(name = "email")
//        private Login login;

        @JsonManagedReference
        @OneToMany(mappedBy = "restaurantOwner",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Dish> dish;
    }

