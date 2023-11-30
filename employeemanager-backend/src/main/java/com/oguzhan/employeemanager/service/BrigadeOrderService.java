package com.oguzhan.employeemanager.service;

import com.oguzhan.employeemanager.dto.BrigadeDTO;
import com.oguzhan.employeemanager.dto.BrigadeOrderDTO;
import com.oguzhan.employeemanager.dto.RankDTO;
import com.oguzhan.employeemanager.dto.TmkDTO;
import com.oguzhan.employeemanager.model.BrigadeOrder;
import com.oguzhan.employeemanager.model.Rank;
import com.oguzhan.employeemanager.repo.BrigadeOrderRepo;
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
public class BrigadeOrderService {
    private final BrigadeOrderRepo brigadeOrderRepo;
    private final RankRepo rankRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public BrigadeOrderService(BrigadeOrderRepo brigadeOrderRepo, RankRepo rankRepo, ModelMapper modelMapper) {
        this.brigadeOrderRepo = brigadeOrderRepo;
        this.rankRepo = rankRepo;
        this.modelMapper = modelMapper;
    }

    public List<BrigadeOrderDTO> findAllBrigadeOrdersByBrigadeIdAndKorpusOrderId(Long brigadeId, Long korpusOrderId){
        Type listType = new TypeToken<List<RankDTO>>() {}.getType();
        List<BrigadeOrder> brigadeOrders = brigadeOrderRepo.findAllBrigadeOrdersByBrigadeIdAndKorpusOrderId(brigadeId, korpusOrderId);
        List<BrigadeOrderDTO> brigadeOrderDTOS = new ArrayList<>();
        for (var brigadeOrder : brigadeOrders){
            BrigadeOrderDTO dto = new BrigadeOrderDTO(brigadeOrder.getId(), modelMapper.map(brigadeOrder.getBrigade(), BrigadeDTO.class), modelMapper.map(brigadeOrder.getTmk(), TmkDTO.class));
            List<Rank> ranks = rankRepo.findAllByBrigadeOrderId(brigadeOrder.getId());
            ranks = ranks.stream().sorted(Comparator.comparing(object -> object.getRankType().getRankTypeName())).toList();
            List<RankDTO> rankDTOS = modelMapper.map(ranks, listType);
            dto.setBrigadeRanks( rankDTOS);
            brigadeOrderDTOS.add(dto);
        }
        return brigadeOrderDTOS;
    }

    public BrigadeOrderDTO updateBrigadeOrder(BrigadeOrderDTO brigadeOrder){
        List<Rank> ranks = rankRepo.findAllByBrigadeOrderId(brigadeOrder.getId());
        for (var rank : ranks){
            RankDTO ra= brigadeOrder.getBrigadeRanks().stream().filter(x -> x.getRankType() == rank.getRankType()).findFirst().get();
            rank.setAmount(ra.getAmount());
            rankRepo.save(rank);
        }
        return brigadeOrder;
    }
}
