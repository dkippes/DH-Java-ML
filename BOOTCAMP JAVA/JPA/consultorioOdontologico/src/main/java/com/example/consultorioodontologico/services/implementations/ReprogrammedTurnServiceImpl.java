package com.example.consultorioodontologico.services.implementations;

import com.example.consultorioodontologico.models.daos.ReprogrammedDAO;
import com.example.consultorioodontologico.repositories.IReprogrammedTurnRepository;
import com.example.consultorioodontologico.services.IReprogrammedTurnService;
import org.springframework.stereotype.Service;

@Service
public class ReprogrammedTurnServiceImpl implements IReprogrammedTurnService {
    IReprogrammedTurnRepository repository;

    public ReprogrammedTurnServiceImpl(IReprogrammedTurnRepository repository) {
        this.repository = repository;
    }

    @Override
    public void reprogrammedTurn(ReprogrammedDAO reprogrammed) {
        repository.save(reprogrammed);
    }
}
