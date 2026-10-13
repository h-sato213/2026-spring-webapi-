package com.example.kakeboapi.service;

import com.example.kakeboapi.dto.Kakebo;
import com.example.kakeboapi.exception.KakeboArgumentNotValidException;
import com.example.kakeboapi.exception.KakeboNotFoundException;
import com.example.kakeboapi.repository.KakeboRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KakeboService {
    private final KakeboRepository kakeboRepository;

    public KakeboService(KakeboRepository kakeboRepository) {
        this.kakeboRepository = kakeboRepository;
    }

    public List<Kakebo> selectAllKakebos() {return kakeboRepository.selectAllKakebos();}

    public Kakebo insertKakebo(Kakebo kakebo) {

        if(kakebo.getTitle() == null || kakebo.getTitle().isEmpty()) {
            throw new KakeboArgumentNotValidException("Title is empty");
        }

        if(kakebo.getValue() == 0) {
            throw new KakeboArgumentNotValidException("Value is empty");
        }
        kakeboRepository.insertKakebo(kakebo);
        return kakebo;
    }

    public Kakebo findById(long id) {
        Kakebo kakebo = kakeboRepository.findById(id);

        if(kakebo == null) {
            throw new KakeboNotFoundException(id);
        }

        return kakebo;
    }

    public boolean delete(long id) {
        if(!kakeboRepository.delete(id)) {
            throw new KakeboNotFoundException(id);
        }
        return true;
    }

    @Transactional
    public Kakebo update(Kakebo kakebo, long id) {
        if(kakebo.getTitle() == null || kakebo.getTitle().isEmpty()) {
            throw new KakeboArgumentNotValidException("Title is empty");
        }
        if(kakebo.getValue() == 0) {
            throw new KakeboArgumentNotValidException("Value is empty");
        }

        Kakebo targetKakebo = kakeboRepository.findById(id);
        if(targetKakebo == null) {
            throw new KakeboNotFoundException(id);
        }

        kakebo.setId(id);
        kakebo.setCreatedAt(targetKakebo.getCreatedAt());
        return kakeboRepository.update(kakebo);
    }

}
