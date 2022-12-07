package com.unipampa.BeerNote.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.unipampa.BeerNote.controller.BeerController;
import com.unipampa.BeerNote.data.BeerVO;
import com.unipampa.BeerNote.exceptions.ResourceNotFoundException;
import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.repository.BeerRepository;
import com.unipampa.BeerNote.utils.DozerMapper;

@Service
public class BeerService {

    @Autowired
    BeerRepository beerRepository;

    private Logger logger = Logger.getLogger(BeerService.class.getName());

    public List<BeerVO> listAllBeer() {
        logger.info("Finding Beers");
        var beers = DozerMapper.parseListObjects(beerRepository.findAll(), BeerVO.class);
        beers.stream().forEach(p -> {
            try {
                p.add(linkTo(methodOn(BeerController.class).findById(p.getKey())).withSelfRel());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return beers;
    }

    public BeerVO listById(Integer id) {
        logger.info("Finding a Beer");
        Beer entity = beerRepository.findById(id);

        var vo = DozerMapper.parseObject(entity, BeerVO.class);
        vo.add(linkTo(methodOn(BeerController.class).findById(id)).withSelfRel());

        return vo;
    }

    public Beer saveBeer(Beer beer) {
        logger.info("Creating a Beer");

        return beerRepository.save(beer);
    }

    public BeerVO updateBeer(BeerVO beerVO) {
        logger.info("Updating Beer");
        Beer entity = beerRepository.findById(beerVO.getKey());

        entity.setName(beerVO.getName());
        entity.setDescription(beerVO.getDescription());

        BeerVO vo = DozerMapper.parseObject(beerRepository.save(entity), BeerVO.class);
        vo.add(linkTo(methodOn(BeerController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void deleteBeer(Integer id) {
        logger.info("Deleting person");
        Beer beer = beerRepository.findById(id);
        beerRepository.delete(beer);
    }

}
