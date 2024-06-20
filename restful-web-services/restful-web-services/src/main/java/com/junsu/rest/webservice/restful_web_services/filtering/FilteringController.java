package com.junsu.rest.webservice.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    private static MappingJacksonValue makeBeanFilter(SomeBean toJacksonBean, String[] exceptArr) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(toJacksonBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(exceptArr);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    private static MappingJacksonValue makeListFilter(List toJacksonList,String[] exceptArr) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(toJacksonList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(exceptArr);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        String[] filteredString = {"field1","field3"};
        return makeBeanFilter(someBean,filteredString );
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<SomeBean> someBeanList;
        someBeanList = Arrays.asList( new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"));
        String[] filteredString = {"field2","field3"};

        return makeListFilter(someBeanList,filteredString);
    }
}
