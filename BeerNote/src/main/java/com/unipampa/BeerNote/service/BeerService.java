package com.unipampa.BeerNote.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return DozerMapper.parseListObjects(beerRepository.findAll(), BeerVO.class);
    }

    public BeerVO listById(Integer id) {
        logger.info("Finding a Beer");
        Beer entity;
        try {
            entity = beerRepository.findById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Beer not found");
        }
        return DozerMapper.parseObject(entity, BeerVO.class);
    }

    public BeerVO saveBeer(BeerVO beerVO) {
        logger.info("Creating a Beer");

        Beer entity = DozerMapper.parseObject(beerVO, Beer.class);

        BeerVO vo = DozerMapper.parseObject(beerRepository.save(entity), BeerVO.class);

        return vo;
    }

    public BeerVO updateBeer(BeerVO beerVO) {
        logger.info("Updating Beer");
        Beer entity = beerRepository.findById(beerVO.getId());

        entity.setName(beerVO.getName());
        entity.setDescription(beerVO.getDescription());

        BeerVO vo = DozerMapper.parseObject(beerRepository.save(entity), BeerVO.class);
        return vo;
    }

    public void deleteBeer(Integer id) {
        logger.info("Deleting person");
        Beer beer = beerRepository.findById(id);
        beerRepository.delete(beer);
    }

}
