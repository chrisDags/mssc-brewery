package com.dags.msscbrewery.web.controller.v2;


import com.dags.msscbrewery.web.model.v2.BeerDtoV2;
import com.dags.msscbrewery.web.services.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    @Autowired
    private BeerServiceV2 beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> handlePost(@Valid @RequestBody BeerDtoV2 beerDto){

        log.debug("in handle post...");
        val savedDto = beerService.saveNewBeer(beerDto);

        var headers = new HttpHeaders();
        //todo: hostname url
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> HandleUpdate(@PathVariable("beerId") UUID beerId,  @Valid @RequestBody BeerDtoV2 beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{beerId}")
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteBeerById(beerId);
    }

}
