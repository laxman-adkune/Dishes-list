package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.entity.Dish;
import com.fooddeliveryapp.exception.DishIdNotFoundException;
import com.fooddeliveryapp.exception.DishNameNotFoundException;
import com.fooddeliveryapp.exception.InvalidDishDataException;
import com.fooddeliveryapp.exception.InvalidDishDetailsException;
import com.fooddeliveryapp.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DishController {

    @Autowired
    private IDishService iDishService;

    @PostMapping("/dish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dishes) throws InvalidDishDetailsException {
        return new ResponseEntity<Dish>(iDishService.addDish(dishes), HttpStatus.OK);
    }

    @GetMapping("/dish")
    public ResponseEntity<List<Dish>> getAllDishes(){
        return new ResponseEntity<List<Dish>>(iDishService.getAllDishes(),HttpStatus.OK);
    }

    @GetMapping("/dish/{dishId}")
    public ResponseEntity<Dish>  getDishById(@PathVariable("dishId") Long dishId) throws DishIdNotFoundException {
        return new ResponseEntity<Dish>(iDishService.getDishById(dishId), HttpStatus.OK);
    }

    @GetMapping("/dish/byname/{dishName}")
    public ResponseEntity<List<Dish>> getDishByName(@PathVariable("dishName") String dishName) throws DishNameNotFoundException {
        return new ResponseEntity<List<Dish>>(iDishService.getDishByName(dishName),HttpStatus.OK);
    }

    @PutMapping("/dish")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dishes) throws InvalidDishDetailsException {
        return new ResponseEntity<Dish>(iDishService.updateDish(dishes),HttpStatus.OK);
    }

    @DeleteMapping("/dish/{dishId}")
    public ResponseEntity<List<Dish>> deleteDishById(@PathVariable("dishId") Long dishId) throws InvalidDishDataException {
        List<Dish> dishList = iDishService.deleteDishById(dishId);
        return new ResponseEntity<List<Dish>>(dishList, HttpStatus.OK);
    }
}
