package com.example.kakeboapi.repository;

import com.example.kakeboapi.dto.Kakebo;
import com.example.kakeboapi.exception.KakeboNotFoundException;
import com.example.kakeboapi.mapper.KakeboMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KakeboRepository {
    private final KakeboMapper kakeboMapper;

    public KakeboRepository(KakeboMapper kakeboMapper) {
        this.kakeboMapper = kakeboMapper;
    }

    public List<Kakebo> selectAllKakebos() {return kakeboMapper.selectAllKakebos();}

    public int insertKakebo(Kakebo kakebo) {return kakeboMapper.insert(kakebo);}

    public Kakebo findById(long id) {
        return kakeboMapper.findById(id);
    }

    public boolean delete(long id) {
        return kakeboMapper.delete(id) == 1;
    }

    public Kakebo update(Kakebo kakebo) {
        if(kakeboMapper.update(kakebo) == 0) {
            throw new KakeboNotFoundException(kakebo.getId());
        }
        return kakebo;
    }

    public int selectSum() {
        return kakeboMapper.selectSum();
    }
}
