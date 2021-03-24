package com.dags.msscbrewery.web.mappers;

import com.dags.msscbrewery.domain.Beer;
import com.dags.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
