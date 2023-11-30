package com.oguzhan.employeemanager.service;

import com.oguzhan.employeemanager.dto.*;
import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.KorpusOrder;
import com.oguzhan.employeemanager.model.Rank;
import com.oguzhan.employeemanager.repo.BrigadeOrderRepo;
import com.oguzhan.employeemanager.repo.KorpusOrderRepo;
import com.oguzhan.employeemanager.repo.RankRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class KorpusOrderService {
    private final KorpusOrderRepo korpusOrderRepo;
    private final RankRepo rankRepo;
    private final BrigadeOrderRepo brigadeOrderRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public KorpusOrderService(KorpusOrderRepo korpusOrderRepo, RankRepo rankRepo, BrigadeOrderRepo brigadeOrderRepo, ModelMapper modelMapper) {
        this.korpusOrderRepo = korpusOrderRepo;
        this.rankRepo = rankRepo;
        this.brigadeOrderRepo = brigadeOrderRepo;
        this.modelMapper = modelMapper;
    }

    public List<KorpusOrderDTO> findAllKorpusOrdersByKorpusId(Long korpusId){
        Type listRankType = new TypeToken<List<RankDTO>>() {}.getType();
        List<KorpusOrder> korpusOrders = korpusOrderRepo.findAllKorpusOrdersByKorpusId(korpusId);
        List<KorpusOrderDTO> korpusOrderDTOS = new ArrayList<>();
        for (var korpusOrder : korpusOrders){
            KorpusOrderDTO korpusOrderDTO = new KorpusOrderDTO(korpusOrder.getId(), modelMapper.map(korpusOrder.getKorpus(), KorpusDTO.class), modelMapper.map(korpusOrder.getTmk(), TmkDTO.class));
            List<BrigadeOrder> brigadeOrders = brigadeOrderRepo.findAllBrigadeOrdersByKorpusOrderId(korpusOrder.getId());
            brigadeOrders = brigadeOrders.stream().sorted(Comparator.comparing(object -> object.getBrigade().getName())).toList();
            List<BrigadeOrderDTO> brigadeOrderDTOS = new ArrayList<>();
            for (var brigadeOrder : brigadeOrders){
                BrigadeOrderDTO brigadeOrderDTO = new BrigadeOrderDTO(brigadeOrder.getId(), modelMapper.map(brigadeOrder.getBrigade(), BrigadeDTO.class), modelMapper.map(korpusOrder.getTmk(), TmkDTO.class));
                List<Rank> ranks = rankRepo.findAllByBrigadeOrderId(brigadeOrder.getId());
                ranks = ranks.stream().sorted(Comparator.comparing(object -> object.getRankType().getRankTypeName())).toList();
                List<RankDTO> rankDTOS = modelMapper.map(ranks, listRankType);
                brigadeOrderDTO.setBrigadeRanks(rankDTOS);
                brigadeOrderDTOS.add(brigadeOrderDTO);
            }
            korpusOrderDTO.setBrigadeOrders(brigadeOrderDTOS);
            korpusOrderDTOS.add(korpusOrderDTO);
        }
        return korpusOrderDTOS;
    }
}
