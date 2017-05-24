package com.shuidi.zhanggui.api;

import com.shuidi.zhanggui.api.resource.TruckBaseResource;
import com.shuidi.zhanggui.service.bl.TruckBaseService;
import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by wandy on 2017-05-08.
 */
@RestController
@RequestMapping(value = "/truck")
@ExposesResourceFor(TruckBase.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class TruckApi {
    @Autowired
    private TruckBaseService truckBaseService;

    @Autowired
    private EntityLinks entityLinks;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity init(@PathVariable Long id) {
        try {
            TruckBase truckBase = truckBaseService.getById(id);
            TruckBaseResource resource = new TruckBaseResource(truckBase);
            Link selfLink = entityLinks.linkToSingleResource(TruckBase.class,id);
            Link basesLink = entityLinks.linkToCollectionResource(TruckBase.class).withRel("collects").expand("{[$.id]}");
            Link trucksLink = linkTo(methodOn(this.getClass()).getTrucks()).withRel("aa");
            resource.add(selfLink,basesLink,trucksLink);
            return new ResponseEntity<TruckBaseResource>(resource, HttpStatus.OK);

        } catch ( Exception e) {
            System.out.print(e);
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity getTrucks() {
        try {
            TruckBase truckBase = truckBaseService.getById(4292L);
            TruckBaseResource resource = new TruckBaseResource(truckBase);
            Link selfLink = entityLinks.linkToSingleResource(TruckBase.class,1L);
            resource.add(selfLink);
            return new ResponseEntity<TruckBaseResource>(resource, HttpStatus.OK);

        } catch ( Exception e) {
            System.out.print(e);
            e.printStackTrace();
            return ResponseEntity.ok(e);
        }
    }

}
