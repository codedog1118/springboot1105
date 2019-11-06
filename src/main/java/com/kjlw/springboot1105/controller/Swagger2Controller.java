package com.kjlw.springboot1105.controller;

import com.kjlw.springboot1105.entity.Car;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/swag")
public class Swagger2Controller {

    //锁
    private List<Car> carList = Collections.synchronizedList(new ArrayList<Car>());

    @GetMapping("/")
    @ApiOperation(value = "获取所有的车辆信息",notes = "不需要传入cid")
    public List<Car> getAll(){
        return carList;
    }

    @PostMapping("/")
    public String addCar(Car car){
        carList.add(car);
        return "SUCCESS";
    }

    @GetMapping("/{cid}")
    public Car getCarById(@PathVariable(name = "cid") Integer cid){
        for (Car car : carList) {
            if(car.getCid()==cid){
                return car;
            }
        }
        return null;
    }

    @PutMapping("/{cid}")
    @ApiOperation(value = "更新指定cid的车辆信息",notes = "根据cid更新车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid",value = "车辆唯一cid",required = true ,dataType = "Integer"),
            @ApiImplicitParam(name = "newCar",value = "变更信息后的车辆对象",required = true,dataType = "User")
    })
    public String updateCarById(@PathVariable(name = "cid") Integer cid, Car newCar){
        for (Car car : carList) {
            if(car.getCid()==cid){
                car.setCname(newCar.getCname());
                car.setPrice(newCar.getPrice());
            }
        }
        return "SUCCESS";
    }

    @DeleteMapping("/{cid}")
    public String deleteCarById(@PathVariable(name = "cid") Integer cid){
        /*for (Car car : carList) {
            if(car.getCid()==cid){
                carList.remove(car);
            }
        }*/
        carList.remove(getCarById(cid));//直接用上面的通过cid获取Car的方法
        return "SUCCESS";
    }
}
